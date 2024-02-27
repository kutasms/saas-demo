package org.example.saas.core.service.order.strategy;

import com.chia.multienty.core.domain.basic.KeyValuePair;
import com.chia.multienty.core.domain.enums.StatusEnum;
import com.chia.multienty.core.tools.IdWorkerProvider;
import com.chia.multienty.core.tools.MultiTenantContext;
import org.example.saas.core.domain.dto.OrderDTO;
import org.example.saas.core.domain.dto.ProductDTO;
import org.example.saas.core.domain.dto.ProductSkuDTO;
import org.example.saas.core.domain.enums.OrderType;
import org.example.saas.core.dubbo.service.DubboUserService;
import org.example.saas.core.parameter.order.OrderPlaceParameter;
import org.example.saas.core.parameter.order.TradeUpdateParameter;
import org.example.saas.core.parameter.user.CustomerGrowthIncreaseParameter;
import org.example.saas.core.pojo.*;
import org.example.saas.core.service.order.OrderDetailService;
import org.example.saas.core.service.order.OrderItemAttrService;
import org.example.saas.core.service.order.OrderItemService;
import org.example.saas.core.tools.CustomerContext;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NormalOrderPlaceProvider extends AbstractOrderPlaceProvider{
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderItemAttrService orderItemAttrService;

    @Autowired(required = false)
    private DubboUserService dubboUserService;

    @Autowired
    @Lazy
    private NormalOrderPlaceProvider currentProvider;

    @Override
    protected AbstractOrderPlaceProvider getCurrentProxy() {
        return currentProvider;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected List<OrderDTO> createOrders(OrderPlaceParameter parameter, Trade trade) {

        List<OrderDTO> orders = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;
        List<ProductDTO> products = mockProducts();

        for (ProductDTO product : products) {
            for (ProductSkuDTO sku : product.getSkus()) {
                BigDecimal quantity = BigDecimal.valueOf(parameter.getSkuMap().get(sku.getSkuId()));
                total = total.add(sku.getPrice().multiply(quantity));
            }
        }
        BigDecimal discountAmount = BigDecimal.ZERO;
        if(parameter.getCouponId() != null) {
            //模拟2.5元优惠券
            discountAmount = BigDecimal.valueOf(2.5);
        }
        OrderDTO order = new OrderDTO();
        order.setOrderId(IdWorkerProvider.next());
        order.setTradeId(trade.getTradeId());
        order.setOrderType(parameter.getOrderType().getValue().shortValue());
        order.setStatus(StatusEnum.WORKING.getCode());
        order.setPaid(false);
        order.setTenantId(trade.getTenantId());
        order.setRefunded(false);
        order.setCreateTime(trade.getCreateTime());
        order.setCustomerId(CustomerContext.getCustomer().getCustomerId());
        order.setDiscountAmount(discountAmount);
        order.setPaidAmount(total.subtract(discountAmount));
        order.setTotalAmount(total);

        orders.add(order);
        orderService.saveBatch(orders.stream().map(m-> (Order)m).collect(Collectors.toList()));
        // 保存订单详情
        OrderDetail orderDetail = new OrderDetail()
                .setOrderId(order.getOrderId())
                .setTradeId(trade.getTradeId())
                .setTenantId(trade.getTenantId())
                .setCouponId(parameter.getCouponId())
                .setActivityId(parameter.getActivityId())
                .setActivityType(parameter.getActivityType() == null ? null : parameter.getActivityType().getId().shortValue())
                .setCustomerNick(CustomerContext.getCustomer().getNickName())
                .setCustomerPhone(CustomerContext.getCustomer().getPhoneNumber())
                .setCreateTime(trade.getCreateTime())
                .setReceived(false);
        orderDetailService.saveTE(orderDetail);
        order.setDetail(orderDetail);
        dubboUserService.increaseGrowth(new CustomerGrowthIncreaseParameter()
                .setCustomerId(trade.getCustomerId())
                .setTenantId(trade.getTenantId())
                .setGrowth(5));
        // 保存订单子项
        saveOrderItems(parameter, trade, order, products);
        // 修改交易金额
        trade.setDiscountAmount(orders.stream().map(m->m.getDiscountAmount()).reduce((a,b) -> a.add(b)).get());
        trade.setTotalAmount(orders.stream().map(m->m.getTotalAmount()).reduce((a,b)-> a.add(b)).get());
        trade.setPaidAmount(trade.getTotalAmount().subtract(trade.getDiscountAmount()));
        TradeUpdateParameter tradeUpdateParameter = new TradeUpdateParameter();
        BeanUtils.copyProperties(trade, tradeUpdateParameter);
        tradeService.update(tradeUpdateParameter);
        return orders;
    }

    public void saveOrderItems(OrderPlaceParameter parameter, Trade trade, OrderDTO order, List<ProductDTO> products) {
        List<OrderItem> orderItems = new ArrayList<>();
        List<OrderItemAttr> orderItemAttrs = new ArrayList<>();
        for (ProductDTO product : products) {
            for (ProductSkuDTO sku : product.getSkus()) {
                OrderItem orderItem = new OrderItem()
                        .setItemId(IdWorkerProvider.next())
                        .setOrderId(order.getOrderId())
                        .setImage(sku.getImageUrl() == null ? product.getMainImageUrl() : sku.getImageUrl())
                        .setProductId(product.getProductId())
                        .setPrice(sku.getPrice())
                        .setDiffAmount(BigDecimal.ZERO)
                        .setCreateTime(trade.getCreateTime())
                        .setQuantity(parameter.getSkuMap().get(sku.getSkuId()))
                        .setProductName(product.getName())
                        .setSkuName(sku.getAttributes().stream().map(m->m.getValue()).collect(Collectors.joining(",")))
                        .setSkuId(sku.getSkuId())
                        .setTenantId(trade.getTenantId())
                        ;
                orderItem.setTotalAmount(BigDecimal.valueOf(orderItem.getQuantity()).multiply(sku.getPrice()));
                orderItems.add(orderItem);
                for (SkuAttribute attribute : sku.getAttributes()) {
                    OrderItemAttr attr = new OrderItemAttr();
                    attr.setAttrId(IdWorkerProvider.next());
                    attr.setItemId(orderItem.getItemId());
                    attr.setName(attribute.getName());
                    attr.setValue(attribute.getValue());
                    attr.setTenantId(trade.getTenantId());
                    attr.setCodeValue(attribute.getCodeValue());
                    attr.setCodeName(attribute.getCodeName());
                    attr.setCreateTime(trade.getCreateTime());
                    orderItemAttrs.add(attr);
                }
            }
        }

        orderItemService.saveBatchTE(orderItems);
        orderItemAttrService.saveBatchTE(orderItemAttrs);
    }


    public List<ProductDTO> mockProducts() {
        List<ProductDTO> products = new ArrayList<>();
        ProductDTO product1 = new ProductDTO();
        product1.setBrief("商品1");
        product1.setName("商品1");
        product1.setDeleted(false);
        product1.setAllowCoupon(true);
        product1.setDetail("商品1的详情");
        product1.setListed(true);
        product1.setProductId(123L);
        product1.setCategoryId(111L);
        product1.setSkus(mockSkus(product1.getProductId()));
        product1.setStatus(StatusEnum.NORMAL.getCode());
        product1.setMainImageUrl("https://image.baidu.com/?t=12847912");
        product1.setSketch("商品1Sketch");
        product1.setSubtitle("sub title");
        product1.setTenantId(MultiTenantContext.getTenant().getTenantId());
        product1.setVersion(1L);
        products.add(product1);
        return products;
    }

    public List<ProductSkuDTO> mockSkus(Long productId) {
        List<ProductSkuDTO> skus = new ArrayList<>();
        ProductSkuDTO sku = new ProductSkuDTO();
        if(productId.equals(123L)) {
            sku.setSkuId(1L);
            sku.setAttributes(mockSkuAttr(sku.getSkuId()));
            sku.setDeleted(false);
            sku.setPrice(BigDecimal.valueOf(12.5));
            sku.setEnable(true);
            sku.setMode((byte) 1);
            sku.setCreateTime(LocalDateTime.now());
            sku.setImageFileId(333L);
            sku.setOriginalPrice(BigDecimal.valueOf(16.5));
            sku.setProductId(productId);
            sku.setStock(500);
            sku.setTenantId(MultiTenantContext.getTenant().getTenantId());
            sku.setImageUrl("https://image.baidu.com?t=281643");
            sku.setVersion(1L);
        } else {
            sku.setSkuId(2L);
            sku.setAttributes(mockSkuAttr(sku.getSkuId()));
            sku.setDeleted(false);
            sku.setPrice(BigDecimal.valueOf(19.8));
            sku.setEnable(true);
            sku.setMode((byte) 1);
            sku.setCreateTime(LocalDateTime.now());
            sku.setImageFileId(222L);
            sku.setOriginalPrice(BigDecimal.valueOf(26.5));
            sku.setProductId(productId);
            sku.setStock(300);
            sku.setTenantId(MultiTenantContext.getTenant().getTenantId());
            sku.setImageUrl("https://image.baidu.com?t=153917B2382");
            sku.setVersion(2L);
        }
        skus.add(sku);
        return skus;
    }

    public List<SkuAttribute> mockSkuAttr(Long skuId) {
        List<SkuAttribute> attributes = new ArrayList<>();
        if(skuId.equals(1L)) {
            SkuAttribute attribute = new SkuAttribute();
            attribute.setName("颜色");
            attribute.setIndex((byte) 1);
            attribute.setImage("https://image.baidu.com?t=1531233082");
            attribute.setAttrId(39178702L);
            attribute.setValue("红色");
            attribute.setCodeName("attr_1");
            attribute.setCodeValue("attr_v_0");
            attribute.setSkuId(skuId);
            attribute.setTenantId(MultiTenantContext.getTenant().getTenantId());
            attributes.add(attribute);
            SkuAttribute attribute2 = new SkuAttribute();
            attribute2.setName("尺码");
            attribute2.setIndex((byte) 2);
            attribute2.setImage("https://image.baidu.com?t=2321354534");
            attribute2.setAttrId(53243112L);
            attribute2.setValue("XL");
            attribute2.setCodeName("attr_2");
            attribute2.setCodeValue("attr_v_1");
            attribute2.setSkuId(skuId);
            attribute2.setTenantId(MultiTenantContext.getTenant().getTenantId());
            attributes.add(attribute2);
        } else {
            SkuAttribute attribute = new SkuAttribute();
            attribute.setName("颜色");
            attribute.setIndex((byte) 1);
            attribute.setImage("https://image.baidu.com?t=1533212482");
            attribute.setAttrId(339288702L);
            attribute.setValue("蓝色");
            attribute.setCodeName("attr_1");
            attribute.setCodeValue("attr_v_0");
            attribute.setSkuId(skuId);
            attribute.setTenantId(MultiTenantContext.getTenant().getTenantId());
            attributes.add(attribute);
            SkuAttribute attribute2 = new SkuAttribute();
            attribute2.setName("尺码");
            attribute2.setIndex((byte) 2);
            attribute2.setImage("https://image.baidu.com?t=2329874534");
            attribute2.setAttrId(5374652912L);
            attribute2.setValue("XXL");
            attribute2.setCodeName("attr_2");
            attribute2.setCodeValue("attr_v_1");
            attribute2.setSkuId(skuId);
            attribute2.setTenantId(MultiTenantContext.getTenant().getTenantId());
            attributes.add(attribute2);
        }
        return attributes;
    }

    @Override
    public OrderType getType() {
        return OrderType.NORMAL_ORDER;
    }
}

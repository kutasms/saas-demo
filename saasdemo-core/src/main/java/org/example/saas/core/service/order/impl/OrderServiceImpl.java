package org.example.saas.core.service.order.impl;

import com.chia.multienty.core.mybatis.MTJoinWrappers;
import com.chia.multienty.core.util.TimeUtil;
import org.example.saas.core.domain.dto.OrderItemDTO;
import org.example.saas.core.pojo.Order;
import org.example.saas.core.mapper.OrderMapper;
import org.example.saas.core.pojo.OrderDetail;
import org.example.saas.core.service.order.OrderItemService;
import org.example.saas.core.service.order.OrderService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderDTO;
import org.example.saas.core.parameter.order.OrderDetailGetParameter;
import org.example.saas.core.parameter.order.OrderPageGetParameter;
import org.example.saas.core.parameter.order.OrderDeleteParameter;
import org.example.saas.core.parameter.order.OrderSaveParameter;
import org.example.saas.core.parameter.order.OrderUpdateParameter;
import org.example.saas.core.parameter.order.OrderEnableParameter;
import org.example.saas.core.parameter.order.OrderDisableParameter;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.chia.multienty.core.domain.constants.MultientyConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.chia.multienty.core.domain.enums.StatusEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultientyContext;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.chia.multienty.core.tools.IdWorkerProvider;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultientyConstants.DS_SHARDING)
public class OrderServiceImpl extends KutaBaseServiceImpl<OrderMapper, Order> implements OrderService {
    private final OrderItemService orderItemService;

    @Override
    public OrderDTO getDetail(OrderDetailGetParameter parameter) {
        return selectJoinOne(OrderDTO.class,
                        MPJWrappers.<Order>lambdaJoin()
                        .eq(Order::getTenantId, parameter.getTenantId())
                        .eq(Order::getCreateTime, parameter.getCreateTime())
                        .eq(Order::getOrderId, parameter.getOrderId()));
    }

    @Override
    public List<OrderDTO> getList(Long tradeId, Long tenantId, LocalDateTime createTime,
                                  Boolean containsDetail, Boolean containsItems) {
        List<OrderDTO> list = null;
        if(containsDetail) {
            list = selectJoinList(OrderDTO.class, MTJoinWrappers.lambda(Order.class)
                    .selectAll(Order.class)
                    .selectAssociation(OrderDetail.class, OrderDTO::getDetail)
                    .leftJoin(OrderDetail.class, OrderDetail::getOrderId, Order::getOrderId)
                    .eq(Order::getTenantId, tenantId)
                    .eq(Order::getTradeId, tradeId)
                    .ge(Order::getCreateTime, TimeUtil.minTime(createTime.toLocalDate()))
                    .le(Order::getCreateTime, TimeUtil.maxTime(createTime.toLocalDate()))
            );
        } else {
            list = selectJoinList(OrderDTO.class, MTJoinWrappers.lambda(Order.class)
                    .eq(Order::getTenantId, tenantId)
                    .eq(Order::getTradeId, tradeId)
                    .ge(Order::getCreateTime, TimeUtil.minTime(createTime.toLocalDate()))
                    .le(Order::getCreateTime, TimeUtil.maxTime(createTime.toLocalDate())));
        }
        if(containsItems && list.size() > 0) {
            List<OrderItemDTO> itemList = orderItemService.getList(tenantId, createTime.toLocalDate(),
                    list.stream().map(m -> m.getOrderId()).collect(Collectors.toList()));
            for (OrderDTO order : list) {
                order.setItems(itemList.stream().filter(p->p.getOrderId().equals(order)).collect(Collectors.toList()));
            }
        }
        return list;
    }

    @Override
    public void update(OrderUpdateParameter parameter) {
        Order order = new Order();
        BeanUtils.copyProperties(parameter, order);
        update(order, new LambdaQueryWrapper<Order>()
                .eq(Order::getTenantId, parameter.getTenantId())
                .eq(Order::getCreateTime, parameter.getCreateTime())
                .eq(Order::getOrderId, parameter.getOrderId()));
    }

    @Override
    public void delete(OrderDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<Order>()
                .eq(Order::getTenantId, parameter.getTenantId())
                .eq(Order::getCreateTime, parameter.getCreateTime())
                .eq(Order::getOrderId, parameter.getOrderId()));
    }

    @Override
    public IPage<OrderDTO> getPage(OrderPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), OrderDTO.class,
                new MTLambdaWrapper<Order>()
                        .solveGenericParameters(parameter)
                        .eq(Order::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getOrderIds()),
                                Order::getOrderId,
                                parameter.getOrderIds())
        );
    }

    @Override
    public void save(OrderSaveParameter parameter) {
        Order order = new Order();
        BeanUtils.copyProperties(parameter, order);
        order.setOrderId(IdWorkerProvider.next());
        saveTE(order);
        order.setTenantId(MultientyContext.getTenant().getTenantId());
        parameter.setOrderId(order.getOrderId());
    }


    @Override
    public void enable(OrderEnableParameter parameter) {
        Order order = new Order();
        BeanUtils.copyProperties(parameter, order);
        order.setStatus(StatusEnum.NORMAL.getCode());
        update(order, new LambdaQueryWrapper<Order>()
                .eq(Order::getTenantId, parameter.getTenantId())
                .eq(Order::getCreateTime, parameter.getCreateTime())
                .eq(Order::getOrderId, parameter.getOrderId()));

    }

    @Override
    public void disable(OrderDisableParameter parameter) {
        Order order = new Order();
        BeanUtils.copyProperties(parameter, order);
        order.setStatus(StatusEnum.DISABLED.getCode());
        update(order, new LambdaQueryWrapper<Order>()
                .eq(Order::getTenantId, parameter.getTenantId())
                .eq(Order::getCreateTime, parameter.getCreateTime())
                .eq(Order::getOrderId, parameter.getOrderId()));
    }
}

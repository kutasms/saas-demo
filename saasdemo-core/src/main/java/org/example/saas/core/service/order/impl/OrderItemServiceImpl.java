package org.example.saas.core.service.order.impl;

import org.example.saas.core.pojo.OrderItem;
import org.example.saas.core.mapper.OrderItemMapper;
import org.example.saas.core.service.order.OrderItemService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderItemDTO;
import org.example.saas.core.parameter.order.OrderItemDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemSaveParameter;
import org.example.saas.core.parameter.order.OrderItemUpdateParameter;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.chia.multienty.core.domain.constants.MultiTenantConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.chia.multienty.core.domain.enums.StatusEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultiTenantContext;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.chia.multienty.core.tools.IdWorkerProvider;
/**
 * <p>
 * 订单项 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class OrderItemServiceImpl extends KutaBaseServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {


    @Override
    public OrderItemDTO getDetail(OrderItemDetailGetParameter parameter) {
        return selectJoinOne(OrderItemDTO.class,
                        MPJWrappers.<OrderItem>lambdaJoin()
                        .eq(OrderItem::getTenantId, parameter.getTenantId())
                        .eq(OrderItem::getCreateTime, parameter.getCreateTime())
                        .eq(OrderItem::getItemId, parameter.getItemId()));
    }

    @Override
    public void update(OrderItemUpdateParameter parameter) {
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(parameter, orderItem);
        update(orderItem, new LambdaQueryWrapper<OrderItem>()
                .eq(OrderItem::getTenantId, parameter.getTenantId())
                .eq(OrderItem::getCreateTime, parameter.getCreateTime())
                .eq(OrderItem::getItemId, parameter.getItemId()));
    }

    @Override
    public void delete(OrderItemDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<OrderItem>()
                .eq(OrderItem::getTenantId, parameter.getTenantId())
                .eq(OrderItem::getCreateTime, parameter.getCreateTime())
                .eq(OrderItem::getItemId, parameter.getItemId()));
    }

    @Override
    public IPage<OrderItemDTO> getPage(OrderItemPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), OrderItemDTO.class,
                new MTLambdaWrapper<OrderItem>()
                        .solveGenericParameters(parameter)
                        .eq(OrderItem::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getItemIds()),
                                OrderItem::getItemId,
                                parameter.getItemIds())
        );
    }

    @Override
    public void save(OrderItemSaveParameter parameter) {
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(parameter, orderItem);
        orderItem.setItemId(IdWorkerProvider.next());
        saveTE(orderItem);
        orderItem.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setItemId(orderItem.getItemId());
    }


}

package org.example.saas.core.service.order.impl;

import org.example.saas.core.pojo.Order;
import org.example.saas.core.mapper.OrderMapper;
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
 * 订单 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class OrderServiceImpl extends KutaBaseServiceImpl<OrderMapper, Order> implements OrderService {


    @Override
    public OrderDTO getDetail(OrderDetailGetParameter parameter) {
        return selectJoinOne(OrderDTO.class,
                        MPJWrappers.<Order>lambdaJoin()
                        .eq(Order::getTenantId, parameter.getTenantId())
                        .eq(Order::getCreateTime, parameter.getCreateTime())
                        .eq(Order::getOrderId, parameter.getOrderId()));
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
        order.setTenantId(MultiTenantContext.getTenant().getTenantId());
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

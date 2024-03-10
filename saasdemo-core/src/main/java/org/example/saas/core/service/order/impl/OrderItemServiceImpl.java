package org.example.saas.core.service.order.impl;

import com.chia.multienty.core.util.TimeUtil;
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
import com.chia.multienty.core.domain.constants.MultientyConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultientyContext;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.chia.multienty.core.tools.IdWorkerProvider;

import java.time.LocalDate;
import java.util.List;

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
@DS(MultientyConstants.DS_SHARDING)
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
    public List<OrderItemDTO> getList(Long tenantId, LocalDate date, List<Long> orderIds) {
        return selectJoinList(OrderItemDTO.class, mtLambdaWrapper()
                .in(OrderItem::getOrderId, orderIds)
                .eq(OrderItem::getTenantId, tenantId)
                .ge(OrderItem::getCreateTime, TimeUtil.minTime(date))
                .le(OrderItem::getCreateTime, TimeUtil.maxTime(date))
        );
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
        orderItem.setTenantId(MultientyContext.getTenant().getTenantId());
        parameter.setItemId(orderItem.getItemId());
    }


}

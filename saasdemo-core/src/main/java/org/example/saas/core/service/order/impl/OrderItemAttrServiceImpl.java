package org.example.saas.core.service.order.impl;

import org.example.saas.core.pojo.OrderItemAttr;
import org.example.saas.core.mapper.OrderItemAttrMapper;
import org.example.saas.core.service.order.OrderItemAttrService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderItemAttrDTO;
import org.example.saas.core.parameter.order.OrderItemAttrDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemAttrSaveParameter;
import org.example.saas.core.parameter.order.OrderItemAttrUpdateParameter;
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
 * 订单项属性 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class OrderItemAttrServiceImpl extends KutaBaseServiceImpl<OrderItemAttrMapper, OrderItemAttr> implements OrderItemAttrService {


    @Override
    public OrderItemAttrDTO getDetail(OrderItemAttrDetailGetParameter parameter) {
        return selectJoinOne(OrderItemAttrDTO.class,
                        MPJWrappers.<OrderItemAttr>lambdaJoin()
                        .eq(OrderItemAttr::getTenantId, parameter.getTenantId())
                        .eq(OrderItemAttr::getCreateTime, parameter.getCreateTime())
                        .eq(OrderItemAttr::getItemId, parameter.getItemId()));
    }

    @Override
    public void update(OrderItemAttrUpdateParameter parameter) {
        OrderItemAttr orderItemAttr = new OrderItemAttr();
        BeanUtils.copyProperties(parameter, orderItemAttr);
        update(orderItemAttr, new LambdaQueryWrapper<OrderItemAttr>()
                .eq(OrderItemAttr::getTenantId, parameter.getTenantId())
                .eq(OrderItemAttr::getCreateTime, parameter.getCreateTime())
                .eq(OrderItemAttr::getItemId, parameter.getItemId()));
    }

    @Override
    public void delete(OrderItemAttrDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<OrderItemAttr>()
                .eq(OrderItemAttr::getTenantId, parameter.getTenantId())
                .eq(OrderItemAttr::getCreateTime, parameter.getCreateTime())
                .eq(OrderItemAttr::getItemId, parameter.getItemId()));
    }

    @Override
    public IPage<OrderItemAttrDTO> getPage(OrderItemAttrPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), OrderItemAttrDTO.class,
                new MTLambdaWrapper<OrderItemAttr>()
                        .solveGenericParameters(parameter)
                        .eq(OrderItemAttr::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getItemIds()),
                                OrderItemAttr::getItemId,
                                parameter.getItemIds())
        );
    }

    @Override
    public void save(OrderItemAttrSaveParameter parameter) {
        OrderItemAttr orderItemAttr = new OrderItemAttr();
        BeanUtils.copyProperties(parameter, orderItemAttr);
        orderItemAttr.setItemId(IdWorkerProvider.next());
        saveTE(orderItemAttr);
        orderItemAttr.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setItemId(orderItemAttr.getItemId());
    }


}

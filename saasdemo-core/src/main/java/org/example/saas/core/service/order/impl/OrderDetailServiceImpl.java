package org.example.saas.core.service.order.impl;

import org.example.saas.core.pojo.OrderDetail;
import org.example.saas.core.mapper.OrderDetailMapper;
import org.example.saas.core.service.order.OrderDetailService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderDetailDTO;
import org.example.saas.core.parameter.order.OrderDetailDetailGetParameter;
import org.example.saas.core.parameter.order.OrderDetailPageGetParameter;
import org.example.saas.core.parameter.order.OrderDetailDeleteParameter;
import org.example.saas.core.parameter.order.OrderDetailSaveParameter;
import org.example.saas.core.parameter.order.OrderDetailUpdateParameter;
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
 * 订单详情 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class OrderDetailServiceImpl extends KutaBaseServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {


    @Override
    public OrderDetailDTO getDetail(OrderDetailDetailGetParameter parameter) {
        return selectJoinOne(OrderDetailDTO.class,
                        MPJWrappers.<OrderDetail>lambdaJoin()
                        .eq(OrderDetail::getTenantId, parameter.getTenantId())
                        .eq(OrderDetail::getCreateTime, parameter.getCreateTime())
                        .eq(OrderDetail::getOrderId, parameter.getOrderId()));
    }

    @Override
    public void update(OrderDetailUpdateParameter parameter) {
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(parameter, orderDetail);
        update(orderDetail, new LambdaQueryWrapper<OrderDetail>()
                .eq(OrderDetail::getTenantId, parameter.getTenantId())
                .eq(OrderDetail::getCreateTime, parameter.getCreateTime())
                .eq(OrderDetail::getOrderId, parameter.getOrderId()));
    }

    @Override
    public void delete(OrderDetailDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<OrderDetail>()
                .eq(OrderDetail::getTenantId, parameter.getTenantId())
                .eq(OrderDetail::getCreateTime, parameter.getCreateTime())
                .eq(OrderDetail::getOrderId, parameter.getOrderId()));
    }

    @Override
    public IPage<OrderDetailDTO> getPage(OrderDetailPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), OrderDetailDTO.class,
                new MTLambdaWrapper<OrderDetail>()
                        .solveGenericParameters(parameter)
                        .eq(OrderDetail::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getOrderIds()),
                                OrderDetail::getOrderId,
                                parameter.getOrderIds())
        );
    }

    @Override
    public void save(OrderDetailSaveParameter parameter) {
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(parameter, orderDetail);
        orderDetail.setOrderId(IdWorkerProvider.next());
        saveTE(orderDetail);
        orderDetail.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setOrderId(orderDetail.getOrderId());
    }


}

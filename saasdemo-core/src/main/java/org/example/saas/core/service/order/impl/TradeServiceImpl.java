package org.example.saas.core.service.order.impl;

import com.chia.multienty.core.util.TimeUtil;
import org.checkerframework.checker.units.qual.C;
import org.example.saas.core.pojo.Trade;
import org.example.saas.core.mapper.TradeMapper;
import org.example.saas.core.service.order.OrderService;
import org.example.saas.core.service.order.TradeService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.TradeDTO;
import org.example.saas.core.parameter.order.TradeDetailGetParameter;
import org.example.saas.core.parameter.order.TradePageGetParameter;
import org.example.saas.core.parameter.order.TradeDeleteParameter;
import org.example.saas.core.parameter.order.TradeSaveParameter;
import org.example.saas.core.parameter.order.TradeUpdateParameter;
import org.example.saas.core.parameter.order.TradeEnableParameter;
import org.example.saas.core.parameter.order.TradeDisableParameter;
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
/**
 * <p>
 * 交易 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultientyConstants.DS_SHARDING)
public class TradeServiceImpl extends KutaBaseServiceImpl<TradeMapper, Trade> implements TradeService {

    private final OrderService orderService;
    @Override
    public TradeDTO getDetail(TradeDetailGetParameter parameter) {
        TradeDTO trade = selectJoinOne(TradeDTO.class,
                MPJWrappers.<Trade>lambdaJoin()
                        .eq(Trade::getTenantId, parameter.getTenantId())
                        .ge(Trade::getCreateTime, TimeUtil.minTime(parameter.getCreateTime().toLocalDate()))
                        .le(Trade::getCreateTime, TimeUtil.maxTime(parameter.getCreateTime().toLocalDate()))
                        .eq(Trade::getTradeId, parameter.getTradeId()));
        if(parameter.getContainsOrders()) {
            trade.setOrders(orderService.getList(
                    parameter.getTradeId(),
                    parameter.getTenantId(),
                    parameter.getCreateTime(),
                    parameter.getContainsOrderDetail(),
                    parameter.getContainsOrderItems()));
        }
        return trade;
    }

    @Override
    public void update(TradeUpdateParameter parameter) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(parameter, trade);
        update(trade, new LambdaQueryWrapper<Trade>()
                .eq(Trade::getTenantId, parameter.getTenantId())
                .eq(Trade::getCreateTime, parameter.getCreateTime())
                .eq(Trade::getTradeId, parameter.getTradeId()));
    }

    @Override
    public void delete(TradeDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<Trade>()
                .eq(Trade::getTenantId, parameter.getTenantId())
                .eq(Trade::getCreateTime, parameter.getCreateTime())
                .eq(Trade::getTradeId, parameter.getTradeId()));
    }

    @Override
    public IPage<TradeDTO> getPage(TradePageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), TradeDTO.class,
                new MTLambdaWrapper<Trade>()
                        .solveGenericParameters(parameter)
                        .eq(Trade::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getTradeIds()),
                                Trade::getTradeId,
                                parameter.getTradeIds())
        );
    }

    @Override
    public void save(TradeSaveParameter parameter) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(parameter, trade);
        trade.setTradeId(IdWorkerProvider.next());
        saveTE(trade);
        trade.setTenantId(MultientyContext.getTenant().getTenantId());
        parameter.setTradeId(trade.getTradeId());
    }


    @Override
    public void enable(TradeEnableParameter parameter) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(parameter, trade);
        trade.setStatus(StatusEnum.NORMAL.getCode());
        update(trade, new LambdaQueryWrapper<Trade>()
                .eq(Trade::getTenantId, parameter.getTenantId())
                .eq(Trade::getCreateTime, parameter.getCreateTime())
                .eq(Trade::getTradeId, parameter.getTradeId()));

    }

    @Override
    public void disable(TradeDisableParameter parameter) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(parameter, trade);
        trade.setStatus(StatusEnum.DISABLED.getCode());
        update(trade, new LambdaQueryWrapper<Trade>()
                .eq(Trade::getTenantId, parameter.getTenantId())
                .eq(Trade::getCreateTime, parameter.getCreateTime())
                .eq(Trade::getTradeId, parameter.getTradeId()));
    }
}

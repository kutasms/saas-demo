package org.example.saas.core.service.order.strategy;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;

import com.chia.multienty.core.domain.constants.MultiTenantConstants;
import com.chia.multienty.core.domain.enums.StatusEnum;
import com.chia.multienty.core.tools.IdWorkerProvider;
import com.chia.multienty.core.tools.MultiTenantContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.example.saas.core.domain.dto.OrderDTO;
import org.example.saas.core.domain.dto.OrderPlaceResultDTO;
import org.example.saas.core.parameter.order.OrderPlaceParameter;
import org.example.saas.core.pojo.Trade;
import org.example.saas.core.service.order.OrderService;
import org.example.saas.core.service.order.TradeService;
import org.example.saas.core.tools.CustomerContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class AbstractOrderPlaceProvider implements IOrderPlaceProvider {
    @Autowired
    protected OrderService orderService;

    @Autowired
    protected TradeService tradeService;


    @Override
    @GlobalTransactional
    public OrderPlaceResultDTO placeOrder(OrderPlaceParameter parameter) {
        DynamicDataSourceContextHolder.push(MultiTenantConstants.DS_SHARDING);
        Trade trade = createTrade(parameter);
        List<OrderDTO> orders = createOrders(parameter, trade);
        OrderPlaceResultDTO result = new OrderPlaceResultDTO()
                .setOrders(orders)
                .setTrade(trade);

        return result;
    }

    /**
     * 创建交易
     * @param parameter
     * @return
     */
    @DS(MultiTenantConstants.DS_SHARDING)
    protected Trade createTrade(OrderPlaceParameter parameter) {
        Trade trade = new Trade();
        trade.setTradeId(IdWorkerProvider.next());
        trade.setPaid(false);
        trade.setStatus(StatusEnum.NORMAL.getCode());
        trade.setCustomerId(CustomerContext.getCustomer().getCustomerId());
        trade.setTenantId(MultiTenantContext.getTenant().getTenantId());
        trade.setCreateTime(LocalDateTime.now());
        tradeService.saveTE(trade);
        return trade;
    }

    protected abstract List<OrderDTO> createOrders(OrderPlaceParameter parameter, Trade trade);
}
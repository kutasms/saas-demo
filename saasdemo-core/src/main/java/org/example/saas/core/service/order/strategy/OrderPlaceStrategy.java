package org.example.saas.core.service.order.strategy;


import lombok.RequiredArgsConstructor;
import org.example.saas.core.domain.constants.SaasConstants;
import org.example.saas.core.domain.dto.OrderPlaceResultDTO;
import org.example.saas.core.parameter.order.OrderPlaceParameter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 下单策略
 */
@Component
@RequiredArgsConstructor
public class OrderPlaceStrategy {
    private final ObjectProvider<Map<String, IOrderPlaceProvider>> provider;
    public OrderPlaceResultDTO placeOrder(OrderPlaceParameter parameter) {
        Map<String, IOrderPlaceProvider> map = provider.getIfAvailable();
        if(map != null) {
            IOrderPlaceProvider service = map.get(SaasConstants.ORDER_PLACE_PROVIDER_PREFIX + parameter.getOrderType().name());
            return service.placeOrder(parameter);
        }
        return null;
    }
}

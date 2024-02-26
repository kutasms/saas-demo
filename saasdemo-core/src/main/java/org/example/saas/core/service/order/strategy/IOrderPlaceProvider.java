package org.example.saas.core.service.order.strategy;

import org.example.saas.core.domain.dto.OrderPlaceResultDTO;
import org.example.saas.core.domain.enums.OrderType;
import org.example.saas.core.parameter.order.OrderPlaceParameter;

public interface IOrderPlaceProvider {
    OrderType getType();

    OrderPlaceResultDTO placeOrder(OrderPlaceParameter parameter);
}

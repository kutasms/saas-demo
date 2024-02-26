package org.example.saas.core.domain.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import org.example.saas.core.pojo.Trade;

import java.util.List;

@Data
@Accessors(chain = true)
public class OrderPlaceResultDTO {
    private String payUrl;
    private Trade trade;
    private List<OrderDTO> orders;
}

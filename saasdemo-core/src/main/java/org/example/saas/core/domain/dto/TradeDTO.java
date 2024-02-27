package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.Trade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 交易 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="TradeDTO", description="交易DTO对象")
public class TradeDTO extends Trade {
    /**
     * 订单列表
     */
    @ApiModelProperty("订单列表")
    private List<OrderDTO> orders;
}

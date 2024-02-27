package org.example.saas.core.parameter.order;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 交易详情获取请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "TradeDetailGetParameter",description = "交易详情获取请求")
public class TradeDetailGetParameter {
    /**
     * 交易编号
     */
     @ApiModelProperty(value = "交易编号")
     private Long tradeId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @NotNull
    private LocalDateTime createTime;

    /**
     * 是否包含订单列表
     */
    @ApiModelProperty(value = "是否包含订单列表")
    private Boolean containsOrders;

    /**
     * 是否包含订单详情
     */
    private Boolean containsOrderDetail = true;
    /**
     * 是否包含订单项
     */
    private Boolean containsOrderItems = true;
}

package org.example.saas.core.parameter.order;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.chia.multienty.core.annotation.LogMetaId;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderSaveParameter",description = "订单保存请求")
@Accessors(chain = true)
public class OrderSaveParameter {

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @LogMetaId
    @JsonIgnore
    @JsonProperty(required = false)
    private Long orderId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    private Long tradeId;
    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    private Long customerId;
    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;
    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountAmount;
    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    private BigDecimal paidAmount;
    /**
     * 是否已支付
     */
    @ApiModelProperty(value = "是否已支付")
    private Boolean paid;
    /**
     * 是否已退款
     */
    @ApiModelProperty(value = "是否已退款")
    private Boolean refunded;
    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    private Short orderType;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}

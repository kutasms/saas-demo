package org.example.saas.core.parameter.order;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 交易更新请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "TradeUpdateParameter",description = "交易更新请求")
@Accessors(chain = true)
public class TradeUpdateParameter {

    /**
     * 交易编号
     */
     @ApiModelProperty(value = "交易编号")
     @LogMetaId
     private Long tradeId;
    /**
     * 租户编号
     */
     @ApiModelProperty(value = "租户编号")
     @NotNull
     private Long tenantId;
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
     * 订单数量
     */
     @ApiModelProperty(value = "订单数量")
     private Integer orderCount;
    /**
     * 已退款数量
     */
     @ApiModelProperty(value = "已退款数量")
     private Integer refundedCount;
    /**
     * 状态
     */
     @ApiModelProperty(value = "状态")
     private String status;
    /**
     * 乐观锁版本号
     */
     @ApiModelProperty(value = "乐观锁版本号")
     private Long version;
    /**
     * 创建时间
     */
     @ApiModelProperty(value = "创建时间")
     @NotNull
     private LocalDateTime createTime;
}

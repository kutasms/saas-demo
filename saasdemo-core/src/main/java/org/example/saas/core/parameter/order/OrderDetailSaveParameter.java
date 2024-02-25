package org.example.saas.core.parameter.order;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.chia.multienty.core.annotation.LogMetaId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单详情保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderDetailSaveParameter",description = "订单详情保存请求")
@Accessors(chain = true)
public class OrderDetailSaveParameter {

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
     * 是否已收货
     */
    @ApiModelProperty(value = "是否已收货")
    private Boolean received;
    /**
     * 客户昵称
     */
    @ApiModelProperty(value = "客户昵称")
    private String customerNick;
    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;
    /**
     * 优惠券编号
     */
    @ApiModelProperty(value = "优惠券编号")
    private Long couponId;
    /**
     * 活动编号
     */
    @ApiModelProperty(value = "活动编号")
    private Long activityId;
    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型")
    private Short activityType;
}

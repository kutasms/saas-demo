package org.example.saas.core.parameter.order;

import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单详情详情获取请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "OrderDetailDetailGetParameter",description = "订单详情详情获取请求")
public class OrderDetailDetailGetParameter {
    /**
     * 订单编号
     */
     @ApiModelProperty(value = "订单编号")
     private Long orderId;
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
}

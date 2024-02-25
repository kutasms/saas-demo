package org.example.saas.core.parameter.user;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 余额账单详情获取请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@Accessors(chain = true)
@ApiModel(value = "BalanceBillDetailGetParameter",description = "余额账单详情获取请求")
public class BalanceBillDetailGetParameter {
    /**
     * 余额变更记录编号
     */
     @ApiModelProperty(value = "余额变更记录编号")
     private Long billId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
}

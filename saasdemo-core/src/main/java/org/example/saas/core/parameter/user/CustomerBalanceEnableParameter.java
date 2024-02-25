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
 * 客户余额启用请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerBalanceEnableParameter",description = "客户余额启用请求")
@Accessors(chain = true)
public class CustomerBalanceEnableParameter {
    /**
     * 客户编号
     */
     @ApiModelProperty(value = "客户编号")
     private Long customerId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
}

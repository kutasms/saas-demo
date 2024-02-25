package org.example.saas.core.parameter.user;

import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户微信禁用请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerWxDisableParameter",description = "客户微信禁用请求")
@Accessors(chain = true)
public class CustomerWxDisableParameter {
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

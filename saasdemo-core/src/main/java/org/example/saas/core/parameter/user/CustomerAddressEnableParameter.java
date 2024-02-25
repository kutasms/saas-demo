package org.example.saas.core.parameter.user;

import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户地址启用请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerAddressEnableParameter",description = "客户地址启用请求")
@Accessors(chain = true)
public class CustomerAddressEnableParameter {
    /**
     * 客户地址编号
     */
     @ApiModelProperty(value = "客户地址编号")
     private Long addressId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
}

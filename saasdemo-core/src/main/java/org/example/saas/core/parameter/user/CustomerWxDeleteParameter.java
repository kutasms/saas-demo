package org.example.saas.core.parameter.user;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户微信删除请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerWxDeleteParameter",description = "客户微信删除请求")
@Accessors(chain = true)
public class CustomerWxDeleteParameter {

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @LogMetaId
    private Long customerId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;

}

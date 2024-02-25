package org.example.saas.core.parameter.user;

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
 * 客户余额保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerBalanceSaveParameter",description = "客户余额保存请求")
@Accessors(chain = true)
public class CustomerBalanceSaveParameter {

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @LogMetaId
    @JsonIgnore
    @JsonProperty(required = false)
    private Long customerId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 总余额
     */
    @ApiModelProperty(value = "总余额")
    private BigDecimal total;
    /**
     * 可用的余额
     */
    @ApiModelProperty(value = "可用的余额")
    private BigDecimal usable;
    /**
     * 冻结的余额
     */
    @ApiModelProperty(value = "冻结的余额")
    private BigDecimal frozen;
    /**
     * 是否隐藏余额
     */
    @ApiModelProperty(value = "是否隐藏余额")
    private Boolean hidden;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}

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
 * 余额账单保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "BalanceBillSaveParameter",description = "余额账单保存请求")
@Accessors(chain = true)
public class BalanceBillSaveParameter {

    /**
     * 余额变更记录编号
     */
    @ApiModelProperty(value = "余额变更记录编号")
    @LogMetaId
    @JsonIgnore
    @JsonProperty(required = false)
    private Long billId;
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
    /**
     * 变动金额
     */
    @ApiModelProperty(value = "变动金额")
    private BigDecimal amount;
    /**
     * 操作者
     */
    @ApiModelProperty(value = "操作者")
    private Long operator;
    /**
     * 原因
     */
    @ApiModelProperty(value = "原因")
    private String reason;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 触发应用编号
     */
    @ApiModelProperty(value = "触发应用编号")
    private Byte trigger;
    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    private Long tradeId;
    /**
     * 变动前余额
     */
    @ApiModelProperty(value = "变动前余额")
    private BigDecimal before;
    /**
     * 变动后余额
     */
    @ApiModelProperty(value = "变动后余额")
    private BigDecimal after;
}

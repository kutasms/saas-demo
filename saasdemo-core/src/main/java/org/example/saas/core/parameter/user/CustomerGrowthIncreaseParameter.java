package org.example.saas.core.parameter.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 客户成长值增加请求
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "CustomerGrowthIncreaseParameter",description = "客户成长值增加请求")
public class CustomerGrowthIncreaseParameter implements Serializable {
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
     * 增长的成长值
     */
    @ApiModelProperty(value = "增长的成长值")
    @NotNull
    private Integer growth;
}

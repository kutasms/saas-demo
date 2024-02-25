package org.example.saas.core.parameter.user;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户余额更新请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerBalanceUpdateParameter",description = "客户余额更新请求")
@Accessors(chain = true)
public class CustomerBalanceUpdateParameter {

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
     * 状态
     */
     @ApiModelProperty(value = "状态")
     private String status;
    /**
     * 乐观锁版本号
     */
     @ApiModelProperty(value = "乐观锁版本号")
     private Long version;
    /**
     * 创建时间
     */
     @ApiModelProperty(value = "创建时间")
     private LocalDateTime createTime;
}

package org.example.saas.core.parameter.order;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单项属性删除请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderItemAttrDeleteParameter",description = "订单项属性删除请求")
@Accessors(chain = true)
public class OrderItemAttrDeleteParameter {

    /**
     * 订单项编号
     */
    @ApiModelProperty(value = "订单项编号")
    @LogMetaId
    private Long itemId;
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
    private LocalDateTime createTime;

}

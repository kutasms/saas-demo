package org.example.saas.core.parameter.order;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单项属性更新请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderItemAttrUpdateParameter",description = "订单项属性更新请求")
@Accessors(chain = true)
public class OrderItemAttrUpdateParameter {

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
     * 规格名称
     */
     @ApiModelProperty(value = "规格名称")
     private String name;
    /**
     * 规格值
     */
     @ApiModelProperty(value = "规格值")
     private String value;
    /**
     * 规格代码名称
     */
     @ApiModelProperty(value = "规格代码名称")
     private String codeName;
    /**
     * 规格代码值
     */
     @ApiModelProperty(value = "规格代码值")
     private String codeValue;
    /**
     * 创建时间
     */
     @ApiModelProperty(value = "创建时间")
     @NotNull
     private LocalDateTime createTime;
}

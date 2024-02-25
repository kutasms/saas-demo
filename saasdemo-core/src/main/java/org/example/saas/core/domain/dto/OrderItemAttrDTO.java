package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.OrderItemAttr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 订单项属性 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OrderItemAttrDTO", description="订单项属性DTO对象")
public class OrderItemAttrDTO extends OrderItemAttr {
}

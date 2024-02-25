package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 订单项 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OrderItemDTO", description="订单项DTO对象")
public class OrderItemDTO extends OrderItem {
}

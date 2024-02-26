package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.saas.core.pojo.OrderDetail;
import org.example.saas.core.pojo.OrderItem;

import java.util.List;

/**
 * <p>
 * 订单 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OrderDTO", description="订单DTO对象")
public class OrderDTO extends Order {
    private OrderDetail detail;

    private List<OrderItem> items;
    /**
     * 是否包含订单详情
     */
    @ApiModelProperty("是否包含订单详情")
    private Boolean containsDetail;
    /**
     * 是否包含订单项
     */
    @ApiModelProperty("是否包含订单项")
    private Boolean containsItems;
}

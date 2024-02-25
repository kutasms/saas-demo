package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.OrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 订单详情 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="OrderDetailDTO", description="订单详情DTO对象")
public class OrderDetailDTO extends OrderDetail {
}

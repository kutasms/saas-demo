package org.example.saas.core.parameter.order;

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
 * 订单项保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderItemSaveParameter",description = "订单项保存请求")
@Accessors(chain = true)
public class OrderItemSaveParameter {

    /**
     * 订单项编号
     */
    @ApiModelProperty(value = "订单项编号")
    @LogMetaId
    @JsonIgnore
    @JsonProperty(required = false)
    private Long itemId;
    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private Long orderId;
    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private Long productId;
    /**
     * 商品规格编号
     */
    @ApiModelProperty(value = "商品规格编号")
    private Long skuId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;
    /**
     * 商品规格名称
     */
    @ApiModelProperty(value = "商品规格名称")
    private String skuName;
    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;
    /**
     * 购买数量
     */
    @ApiModelProperty(value = "购买数量")
    private Integer quantity;
    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    private BigDecimal totalAmount;
    /**
     * 金额差异
     */
    @ApiModelProperty(value = "金额差异")
    private BigDecimal diffAmount;
    /**
     * 商品主图
     */
    @ApiModelProperty(value = "商品主图")
    private String image;
}

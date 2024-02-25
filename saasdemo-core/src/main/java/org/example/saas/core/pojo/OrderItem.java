package org.example.saas.core.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_order_item")
@ApiModel(value="OrderItem对象", description="订单项")
public class OrderItem implements Serializable {


    /**
     * 订单项编号
     */
    @ApiModelProperty(value = "订单项编号")
    @TableId(value = "item_id", type = IdType.INPUT)
    private Long itemId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @TableField("`order_id`")
    private Long orderId;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    @TableField("`product_id`")
    private Long productId;

    /**
     * 商品规格编号
     */
    @ApiModelProperty(value = "商品规格编号")
    @TableField("`sku_id`")
    private Long skuId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    @TableField("`product_name`")
    private String productName;

    /**
     * 商品规格名称
     */
    @ApiModelProperty(value = "商品规格名称")
    @TableField("`sku_name`")
    private String skuName;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格")
    @TableField("`price`")
    private BigDecimal price;

    /**
     * 购买数量
     */
    @ApiModelProperty(value = "购买数量")
    @TableField("`quantity`")
    private Integer quantity;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    @TableField("`total_amount`")
    private BigDecimal totalAmount;

    /**
     * 金额差异
     */
    @ApiModelProperty(value = "金额差异")
    @TableField("`diff_amount`")
    private BigDecimal diffAmount;

    /**
     * 商品主图
     */
    @ApiModelProperty(value = "商品主图")
    @TableField("`image`")
    private String image;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}

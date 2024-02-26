package org.example.saas.core.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ks_product")
@ApiModel(value="Product对象", description="商品")
public class Product implements Serializable {


    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    @TableId(value = "product_id", type = IdType.AUTO)
    private Long productId;

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
    @TableField("`name`")
    private String name;

    /**
     * 副标题
     */
    @ApiModelProperty(value = "副标题")
    @TableField("`subtitle`")
    private String subtitle;

    /**
     * 简述
     */
    @ApiModelProperty(value = "简述")
    @TableField("`sketch`")
    private String sketch;

    /**
     * 目录
     */
    @ApiModelProperty(value = "目录")
    @TableField("`category_id`")
    private Long categoryId;

    /**
     * 详情
     */
    @ApiModelProperty(value = "详情")
    @TableField("`detail`")
    private String detail;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField(value = "`status`", fill = FieldFill.INSERT)
    private String status;

    /**
     * 价格区间-开始
     */
    @ApiModelProperty(value = "价格区间-开始")
    @TableField("`price_start`")
    private BigDecimal priceStart;

    /**
     * 价格区间-结束
     */
    @ApiModelProperty(value = "价格区间-结束")
    @TableField("`price_end`")
    private BigDecimal priceEnd;

    /**
     * 是否已上架
     */
    @ApiModelProperty(value = "是否已上架")
    @TableField("`listed`")
    private Boolean listed;

    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    private Boolean deleted;

    /**
     * 乐观锁版本号
     */
    @ApiModelProperty(value = "乐观锁版本号")
    @TableField(value = "`version`", fill = FieldFill.INSERT)
    private Long version;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期")
    @TableField(value = "`update_time`", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 卖点
     */
    @ApiModelProperty(value = "卖点")
    @TableField("`brief`")
    private String brief;

    /**
     * 允许使用优惠券
     */
    @ApiModelProperty(value = "允许使用优惠券")
    @TableField("`allow_coupon`")
    private Boolean allowCoupon;


}

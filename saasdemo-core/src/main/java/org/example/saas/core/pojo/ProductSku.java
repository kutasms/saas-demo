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
 * 商品规格
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ks_product_sku")
@ApiModel(value="ProductSku对象", description="商品规格")
public class ProductSku implements Serializable {


    /**
     * sku编号
     */
    @ApiModelProperty(value = "sku编号")
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    /**
     * 货物编号
     */
    @ApiModelProperty(value = "货物编号")
    @TableField("`product_id`")
    private Long productId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 现价
     */
    @ApiModelProperty(value = "现价")
    @TableField("`price`")
    private BigDecimal price;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    @TableField("`original_Price`")
    private BigDecimal originalPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    @TableField("`stock`")
    private Integer stock;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    @TableField("`image_url`")
    private String imageUrl;

    /**
     * 文件编号
     */
    @ApiModelProperty(value = "文件编号")
    @TableField("`image_file_id`")
    private Long imageFileId;

    /**
     * 模式
     */
    @ApiModelProperty(value = "模式")
    @TableField("`mode`")
    private Byte mode;

    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用")
    @TableField("`enable`")
    private Boolean enable;

    /**
     * 乐观锁版本号
     */
    @ApiModelProperty(value = "乐观锁版本号")
    @TableField(value = "`version`", fill = FieldFill.INSERT)
    private Long version;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(value = "`update_time`", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否已删除
     */
    @ApiModelProperty(value = "是否已删除")
    @TableField(value = "`deleted`", fill = FieldFill.INSERT)
    @TableLogic
    private Boolean deleted;


}

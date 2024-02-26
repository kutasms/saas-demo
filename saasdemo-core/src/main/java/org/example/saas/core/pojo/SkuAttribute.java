package org.example.saas.core.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商品规格属性
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ks_sku_attribute")
@ApiModel(value="SkuAttribute对象", description="商品规格属性")
public class SkuAttribute implements Serializable {


    /**
     * 规格属性编号
     */
    @ApiModelProperty(value = "规格属性编号")
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Long attrId;

    /**
     * 规格编号
     */
    @ApiModelProperty(value = "规格编号")
    @TableField("`sku_id`")
    private Long skuId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 规格名称
     */
    @ApiModelProperty(value = "规格名称")
    @TableField("`name`")
    private String name;

    /**
     * 规格值
     */
    @ApiModelProperty(value = "规格值")
    @TableField("`value`")
    private String value;

    /**
     * 规格代码名称
     */
    @ApiModelProperty(value = "规格代码名称")
    @TableField("`code_name`")
    private String codeName;

    /**
     * 规格代码值
     */
    @ApiModelProperty(value = "规格代码值")
    @TableField("`code_value`")
    private String codeValue;

    /**
     * 规格图片
     */
    @ApiModelProperty(value = "规格图片")
    @TableField("`image`")
    private String image;

    /**
     * 排序索引
     */
    @ApiModelProperty(value = "排序索引")
    @TableField("`index`")
    private Byte index;


}

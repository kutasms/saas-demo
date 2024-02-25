package org.example.saas.core.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单项属性
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_order_item_attr")
@ApiModel(value="OrderItemAttr对象", description="订单项属性")
public class OrderItemAttr implements Serializable {


    /**
     * 订单项编号
     */
    @ApiModelProperty(value = "订单项编号")
    @TableId(value = "item_id", type = IdType.INPUT)
    private Long itemId;

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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}

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
 * 客户地址
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_customer_address")
@ApiModel(value="CustomerAddress对象", description="客户地址")
public class CustomerAddress implements Serializable {


    /**
     * 客户地址编号
     */
    @ApiModelProperty(value = "客户地址编号")
    @TableId(value = "address_id", type = IdType.INPUT)
    private Long addressId;

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @TableField("`customer_id`")
    private Long customerId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    @TableField("`name`")
    private String name;

    /**
     * 收货人电话
     */
    @ApiModelProperty(value = "收货人电话")
    @TableField("`phone_number`")
    private String phoneNumber;

    /**
     * 地域
     */
    @ApiModelProperty(value = "地域")
    @TableField("`region`")
    private String region;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    @TableField("`province`")
    private String province;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    @TableField("`city`")
    private String city;

    /**
     * 区县
     */
    @ApiModelProperty(value = "区县")
    @TableField("`district`")
    private String district;

    /**
     * 街道
     */
    @ApiModelProperty(value = "街道")
    @TableField("`street`")
    private String street;

    /**
     * 门牌号
     */
    @ApiModelProperty(value = "门牌号")
    @TableField("`house_number`")
    private String houseNumber;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField(value = "`status`", fill = FieldFill.INSERT)
    private String status;

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


}

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
 * 客户余额
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_customer_balance")
@ApiModel(value="CustomerBalance对象", description="客户余额")
public class CustomerBalance implements Serializable {


    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @TableId(value = "customer_id", type = IdType.INPUT)
    private Long customerId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 总余额
     */
    @ApiModelProperty(value = "总余额")
    @TableField("`total`")
    private BigDecimal total;

    /**
     * 可用的余额
     */
    @ApiModelProperty(value = "可用的余额")
    @TableField("`usable`")
    private BigDecimal usable;

    /**
     * 冻结的余额
     */
    @ApiModelProperty(value = "冻结的余额")
    @TableField("`frozen`")
    private BigDecimal frozen;

    /**
     * 是否隐藏余额
     */
    @ApiModelProperty(value = "是否隐藏余额")
    @TableField("`hidden`")
    private Boolean hidden;

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

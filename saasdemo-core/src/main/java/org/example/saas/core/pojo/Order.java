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
 * 订单
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_order")
@ApiModel(value="Order对象", description="订单")
public class Order implements Serializable {


    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @TableId(value = "order_id", type = IdType.INPUT)
    private Long orderId;

    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @TableField("`tenant_id`")
    private Long tenantId;

    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    @TableField("`trade_id`")
    private Long tradeId;

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @TableField("`customer_id`")
    private Long customerId;

    /**
     * 总金额
     */
    @ApiModelProperty(value = "总金额")
    @TableField("`total_amount`")
    private BigDecimal totalAmount;

    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    @TableField("`discount_amount`")
    private BigDecimal discountAmount;

    /**
     * 支付金额
     */
    @ApiModelProperty(value = "支付金额")
    @TableField("`paid_amount`")
    private BigDecimal paidAmount;

    /**
     * 是否已支付
     */
    @ApiModelProperty(value = "是否已支付")
    @TableField("`paid`")
    private Boolean paid;

    /**
     * 是否已退款
     */
    @ApiModelProperty(value = "是否已退款")
    @TableField("`refunded`")
    private Boolean refunded;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    @TableField("`order_type`")
    private Short orderType;

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

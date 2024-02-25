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
 * 订单详情
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_order_detail")
@ApiModel(value="OrderDetail对象", description="订单详情")
public class OrderDetail implements Serializable {


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
     * 是否已收货
     */
    @ApiModelProperty(value = "是否已收货")
    @TableField("`received`")
    private Boolean received;

    /**
     * 客户昵称
     */
    @ApiModelProperty(value = "客户昵称")
    @TableField("`customer_nick`")
    private String customerNick;

    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    @TableField("`customer_phone`")
    private String customerPhone;

    /**
     * 优惠券编号
     */
    @ApiModelProperty(value = "优惠券编号")
    @TableField("`coupon_id`")
    private Long couponId;

    /**
     * 活动编号
     */
    @ApiModelProperty(value = "活动编号")
    @TableField("`activity_id`")
    private Long activityId;

    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型")
    @TableField("`activity_type`")
    private Short activityType;

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


}

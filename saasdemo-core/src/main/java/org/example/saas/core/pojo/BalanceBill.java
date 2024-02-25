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
 * 余额账单
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_balance_bill")
@ApiModel(value="BalanceBill对象", description="余额账单")
public class BalanceBill implements Serializable {


    /**
     * 余额变更记录编号
     */
    @ApiModelProperty(value = "余额变更记录编号")
    @TableId(value = "bill_id", type = IdType.INPUT)
    private Long billId;

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
     * 变动金额
     */
    @ApiModelProperty(value = "变动金额")
    @TableField("`amount`")
    private BigDecimal amount;

    /**
     * 操作者
     */
    @ApiModelProperty(value = "操作者")
    @TableField("`operator`")
    private Long operator;

    /**
     * 原因
     */
    @ApiModelProperty(value = "原因")
    @TableField("`reason`")
    private String reason;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @TableField("`remark`")
    private String remark;

    /**
     * 触发应用编号
     */
    @ApiModelProperty(value = "触发应用编号")
    @TableField("`trigger`")
    private Byte trigger;

    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    @TableField("`trade_id`")
    private Long tradeId;

    /**
     * 变动前余额
     */
    @ApiModelProperty(value = "变动前余额")
    @TableField("`before`")
    private BigDecimal before;

    /**
     * 变动后余额
     */
    @ApiModelProperty(value = "变动后余额")
    @TableField("`after`")
    private BigDecimal after;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "`create_time`", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}

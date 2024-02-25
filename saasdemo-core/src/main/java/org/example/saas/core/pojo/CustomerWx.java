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
 * 客户微信
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_customer_wx")
@ApiModel(value="CustomerWx对象", description="客户微信")
public class CustomerWx implements Serializable {


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
     * 微信openid
     */
    @ApiModelProperty(value = "微信openid")
    @TableField("`wx_open_id`")
    private String wxOpenId;

    /**
     * 微信unionid
     */
    @ApiModelProperty(value = "微信unionid")
    @TableField("`wx_union_id`")
    private String wxUnionId;

    /**
     * 微信昵称
     */
    @ApiModelProperty(value = "微信昵称")
    @TableField("`wx_nick_name`")
    private String wxNickName;

    /**
     * 微信id
     */
    @ApiModelProperty(value = "微信id")
    @TableField("`wx_id`")
    private String wxId;

    /**
     * 执行令牌
     */
    @ApiModelProperty(value = "执行令牌")
    @TableField("`access_token`")
    private String accessToken;

    /**
     * 刷新令牌
     */
    @ApiModelProperty(value = "刷新令牌")
    @TableField("`refresh_token`")
    private String refreshToken;

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

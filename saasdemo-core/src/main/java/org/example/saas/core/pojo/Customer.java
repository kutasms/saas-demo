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
 * 客户
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("saas_customer")
@ApiModel(value="Customer对象", description="客户")
public class Customer implements Serializable {


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
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    @TableField("`nick_name`")
    private String nickName;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @TableField("`sex`")
    private Byte sex;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @TableField("`birthday`")
    private LocalDateTime birthday;

    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    @TableField("`phone_number`")
    private String phoneNumber;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    @TableField("`avatar_url`")
    private String avatarUrl;

    /**
     * 是否已被拉黑
     */
    @ApiModelProperty(value = "是否已被拉黑")
    @TableField("`in_black_list`")
    private Boolean inBlackList;

    /**
     * 是否会员
     */
    @ApiModelProperty(value = "是否会员")
    @TableField("`is_member`")
    private Boolean isMember;

    /**
     * 会员来源类型
     */
    @ApiModelProperty(value = "会员来源类型")
    @TableField("`member_source_type`")
    private Byte memberSourceType;

    /**
     * 会员编号
     */
    @ApiModelProperty(value = "会员编号")
    @TableField("`member_id`")
    private Long memberId;

    /**
     * 成长值
     */
    @ApiModelProperty(value = "成长值")
    @TableField("`growth`")
    private Integer growth;

    /**
     * 积分
     */
    @ApiModelProperty(value = "积分")
    @TableField("`credit`")
    private Integer credit;

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

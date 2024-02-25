package org.example.saas.core.parameter.user;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.chia.multienty.core.annotation.LogMetaId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户保存请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerSaveParameter",description = "客户保存请求")
@Accessors(chain = true)
public class CustomerSaveParameter {

    /**
     * 客户编号
     */
    @ApiModelProperty(value = "客户编号")
    @LogMetaId
    @JsonIgnore
    @JsonProperty(required = false)
    private Long customerId;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickName;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Byte sex;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;
    /**
     * 电话号码
     */
    @ApiModelProperty(value = "电话号码")
    private String phoneNumber;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;
    /**
     * 是否已被拉黑
     */
    @ApiModelProperty(value = "是否已被拉黑")
    private Boolean inBlackList;
    /**
     * 是否会员
     */
    @ApiModelProperty(value = "是否会员")
    private Boolean isMember;
    /**
     * 会员来源类型
     */
    @ApiModelProperty(value = "会员来源类型")
    private Byte memberSourceType;
    /**
     * 会员编号
     */
    @ApiModelProperty(value = "会员编号")
    private Long memberId;
    /**
     * 成长值
     */
    @ApiModelProperty(value = "成长值")
    private Integer growth;
    /**
     * 积分
     */
    @ApiModelProperty(value = "积分")
    private Integer credit;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}

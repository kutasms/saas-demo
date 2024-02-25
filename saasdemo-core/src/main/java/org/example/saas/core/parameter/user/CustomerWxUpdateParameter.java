package org.example.saas.core.parameter.user;

import lombok.Data;
import com.chia.multienty.core.annotation.LogMetaId;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户微信更新请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerWxUpdateParameter",description = "客户微信更新请求")
@Accessors(chain = true)
public class CustomerWxUpdateParameter {

    /**
     * 客户编号
     */
     @ApiModelProperty(value = "客户编号")
     @LogMetaId
     private Long customerId;
    /**
     * 租户编号
     */
     @ApiModelProperty(value = "租户编号")
     @NotNull
     private Long tenantId;
    /**
     * 微信openid
     */
     @ApiModelProperty(value = "微信openid")
     private String wxOpenId;
    /**
     * 微信unionid
     */
     @ApiModelProperty(value = "微信unionid")
     private String wxUnionId;
    /**
     * 微信昵称
     */
     @ApiModelProperty(value = "微信昵称")
     private String wxNickName;
    /**
     * 微信id
     */
     @ApiModelProperty(value = "微信id")
     private String wxId;
    /**
     * 执行令牌
     */
     @ApiModelProperty(value = "执行令牌")
     private String accessToken;
    /**
     * 刷新令牌
     */
     @ApiModelProperty(value = "刷新令牌")
     private String refreshToken;
    /**
     * 状态
     */
     @ApiModelProperty(value = "状态")
     private String status;
    /**
     * 乐观锁版本号
     */
     @ApiModelProperty(value = "乐观锁版本号")
     private Long version;
    /**
     * 创建时间
     */
     @ApiModelProperty(value = "创建时间")
     private LocalDateTime createTime;
}

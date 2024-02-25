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
 * 客户地址更新请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerAddressUpdateParameter",description = "客户地址更新请求")
@Accessors(chain = true)
public class CustomerAddressUpdateParameter {

    /**
     * 客户地址编号
     */
     @ApiModelProperty(value = "客户地址编号")
     @LogMetaId
     private Long addressId;
    /**
     * 客户编号
     */
     @ApiModelProperty(value = "客户编号")
     private Long customerId;
    /**
     * 租户编号
     */
     @ApiModelProperty(value = "租户编号")
     @NotNull
     private Long tenantId;
    /**
     * 收货人姓名
     */
     @ApiModelProperty(value = "收货人姓名")
     private String name;
    /**
     * 收货人电话
     */
     @ApiModelProperty(value = "收货人电话")
     private String phoneNumber;
    /**
     * 地域
     */
     @ApiModelProperty(value = "地域")
     private String region;
    /**
     * 省份
     */
     @ApiModelProperty(value = "省份")
     private String province;
    /**
     * 城市
     */
     @ApiModelProperty(value = "城市")
     private String city;
    /**
     * 区县
     */
     @ApiModelProperty(value = "区县")
     private String district;
    /**
     * 街道
     */
     @ApiModelProperty(value = "街道")
     private String street;
    /**
     * 门牌号
     */
     @ApiModelProperty(value = "门牌号")
     private String houseNumber;
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

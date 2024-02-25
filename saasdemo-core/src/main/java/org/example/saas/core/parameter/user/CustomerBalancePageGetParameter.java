package org.example.saas.core.parameter.user;

import lombok.Data;
import com.chia.multienty.core.mybatis.DefaultListGetParameter;
import org.example.saas.core.domain.dto.CustomerBalanceDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.util.List;
import lombok.experimental.Accessors;
/**
 * <p>
 * 客户余额分页列表查询请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */

@Data
@ApiModel(value = "CustomerBalancePageGetParameter",description = "客户余额分页列表查询请求")
@Accessors(chain = true)
public class CustomerBalancePageGetParameter extends DefaultListGetParameter<CustomerBalanceDTO>{

    /**
     * 客户编号
     */
     @ApiModelProperty(value = "客户编号列表")
     private List<Long> customerIds;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
}

package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.CustomerBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 客户余额 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="CustomerBalanceDTO", description="客户余额DTO对象")
public class CustomerBalanceDTO extends CustomerBalance {
}

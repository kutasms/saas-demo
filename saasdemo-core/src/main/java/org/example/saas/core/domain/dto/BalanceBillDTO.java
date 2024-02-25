package org.example.saas.core.domain.dto;

import org.example.saas.core.pojo.BalanceBill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * <p>
 * 余额账单 DTO对象
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="BalanceBillDTO", description="余额账单DTO对象")
public class BalanceBillDTO extends BalanceBill {
}

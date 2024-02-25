package org.example.saas.core.parameter.order;

import lombok.Data;
import com.chia.multienty.core.mybatis.DefaultListGetParameter;
import org.example.saas.core.domain.dto.OrderDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.util.List;
import lombok.experimental.Accessors;
/**
 * <p>
 * 订单分页列表查询请求
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */

@Data
@ApiModel(value = "OrderPageGetParameter",description = "订单分页列表查询请求")
@Accessors(chain = true)
public class OrderPageGetParameter extends DefaultListGetParameter<OrderDTO>{

    /**
     * 订单编号
     */
     @ApiModelProperty(value = "订单编号列表")
     private List<Long> orderIds;
    /**
     * 租户编号
     */
    @ApiModelProperty(value = "租户编号")
    @NotNull
    private Long tenantId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @NotNull
    private LocalDateTime createTime;
}

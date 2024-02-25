package org.example.saas.core.service.order;

import org.example.saas.core.pojo.Order;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderDTO;
import org.example.saas.core.parameter.order.OrderDetailGetParameter;
import org.example.saas.core.parameter.order.OrderPageGetParameter;
import org.example.saas.core.parameter.order.OrderDeleteParameter;
import org.example.saas.core.parameter.order.OrderEnableParameter;
import org.example.saas.core.parameter.order.OrderDisableParameter;
import org.example.saas.core.parameter.order.OrderSaveParameter;
import org.example.saas.core.parameter.order.OrderUpdateParameter;
/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
public interface OrderService extends KutaBaseService<Order> {

    OrderDTO getDetail(OrderDetailGetParameter parameter);

    void delete(OrderDeleteParameter parameter);

    IPage<OrderDTO> getPage(OrderPageGetParameter parameter);
    void enable(OrderEnableParameter parameter);

    void disable(OrderDisableParameter parameter);

    void save(OrderSaveParameter parameter);

    void update(OrderUpdateParameter parameter);

}

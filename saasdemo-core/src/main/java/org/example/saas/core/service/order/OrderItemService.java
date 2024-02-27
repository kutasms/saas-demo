package org.example.saas.core.service.order;

import org.example.saas.core.pojo.OrderItem;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderItemDTO;
import org.example.saas.core.parameter.order.OrderItemDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemSaveParameter;
import org.example.saas.core.parameter.order.OrderItemUpdateParameter;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 订单项 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
public interface OrderItemService extends KutaBaseService<OrderItem> {

    OrderItemDTO getDetail(OrderItemDetailGetParameter parameter);

    List<OrderItemDTO> getList(Long tenantId, LocalDate date, List<Long> orderIds);

    void delete(OrderItemDeleteParameter parameter);

    IPage<OrderItemDTO> getPage(OrderItemPageGetParameter parameter);

    void save(OrderItemSaveParameter parameter);

    void update(OrderItemUpdateParameter parameter);

}

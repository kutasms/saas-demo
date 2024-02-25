package org.example.saas.core.service.order;

import org.example.saas.core.pojo.OrderItemAttr;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderItemAttrDTO;
import org.example.saas.core.parameter.order.OrderItemAttrDetailGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrPageGetParameter;
import org.example.saas.core.parameter.order.OrderItemAttrDeleteParameter;
import org.example.saas.core.parameter.order.OrderItemAttrSaveParameter;
import org.example.saas.core.parameter.order.OrderItemAttrUpdateParameter;
/**
 * <p>
 * 订单项属性 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
public interface OrderItemAttrService extends KutaBaseService<OrderItemAttr> {

    OrderItemAttrDTO getDetail(OrderItemAttrDetailGetParameter parameter);

    void delete(OrderItemAttrDeleteParameter parameter);

    IPage<OrderItemAttrDTO> getPage(OrderItemAttrPageGetParameter parameter);

    void save(OrderItemAttrSaveParameter parameter);

    void update(OrderItemAttrUpdateParameter parameter);

}

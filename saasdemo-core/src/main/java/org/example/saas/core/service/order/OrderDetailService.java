package org.example.saas.core.service.order;

import org.example.saas.core.pojo.OrderDetail;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.OrderDetailDTO;
import org.example.saas.core.parameter.order.OrderDetailDetailGetParameter;
import org.example.saas.core.parameter.order.OrderDetailPageGetParameter;
import org.example.saas.core.parameter.order.OrderDetailDeleteParameter;
import org.example.saas.core.parameter.order.OrderDetailSaveParameter;
import org.example.saas.core.parameter.order.OrderDetailUpdateParameter;
/**
 * <p>
 * 订单详情 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
public interface OrderDetailService extends KutaBaseService<OrderDetail> {

    OrderDetailDTO getDetail(OrderDetailDetailGetParameter parameter);

    void delete(OrderDetailDeleteParameter parameter);

    IPage<OrderDetailDTO> getPage(OrderDetailPageGetParameter parameter);

    void save(OrderDetailSaveParameter parameter);

    void update(OrderDetailUpdateParameter parameter);

}

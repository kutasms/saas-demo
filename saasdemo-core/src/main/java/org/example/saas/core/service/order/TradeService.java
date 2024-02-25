package org.example.saas.core.service.order;

import org.example.saas.core.pojo.Trade;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.TradeDTO;
import org.example.saas.core.parameter.order.TradeDetailGetParameter;
import org.example.saas.core.parameter.order.TradePageGetParameter;
import org.example.saas.core.parameter.order.TradeDeleteParameter;
import org.example.saas.core.parameter.order.TradeEnableParameter;
import org.example.saas.core.parameter.order.TradeDisableParameter;
import org.example.saas.core.parameter.order.TradeSaveParameter;
import org.example.saas.core.parameter.order.TradeUpdateParameter;
/**
 * <p>
 * 交易 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
public interface TradeService extends KutaBaseService<Trade> {

    TradeDTO getDetail(TradeDetailGetParameter parameter);

    void delete(TradeDeleteParameter parameter);

    IPage<TradeDTO> getPage(TradePageGetParameter parameter);
    void enable(TradeEnableParameter parameter);

    void disable(TradeDisableParameter parameter);

    void save(TradeSaveParameter parameter);

    void update(TradeUpdateParameter parameter);

}

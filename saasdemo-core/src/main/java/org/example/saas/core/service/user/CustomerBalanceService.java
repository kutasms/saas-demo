package org.example.saas.core.service.user;

import org.example.saas.core.pojo.CustomerBalance;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerBalanceDTO;
import org.example.saas.core.parameter.user.CustomerBalanceDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerBalancePageGetParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDeleteParameter;
import org.example.saas.core.parameter.user.CustomerBalanceEnableParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDisableParameter;
import org.example.saas.core.parameter.user.CustomerBalanceSaveParameter;
import org.example.saas.core.parameter.user.CustomerBalanceUpdateParameter;
/**
 * <p>
 * 客户余额 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
public interface CustomerBalanceService extends KutaBaseService<CustomerBalance> {

    CustomerBalanceDTO getDetail(CustomerBalanceDetailGetParameter parameter);

    void delete(CustomerBalanceDeleteParameter parameter);

    IPage<CustomerBalanceDTO> getPage(CustomerBalancePageGetParameter parameter);
    void enable(CustomerBalanceEnableParameter parameter);

    void disable(CustomerBalanceDisableParameter parameter);

    void save(CustomerBalanceSaveParameter parameter);

    void update(CustomerBalanceUpdateParameter parameter);

}

package org.example.saas.core.service.user;

import org.example.saas.core.pojo.Customer;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerPageGetParameter;
import org.example.saas.core.parameter.user.CustomerDeleteParameter;
import org.example.saas.core.parameter.user.CustomerEnableParameter;
import org.example.saas.core.parameter.user.CustomerDisableParameter;
import org.example.saas.core.parameter.user.CustomerSaveParameter;
import org.example.saas.core.parameter.user.CustomerUpdateParameter;
/**
 * <p>
 * 客户 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
public interface CustomerService extends KutaBaseService<Customer> {

    CustomerDTO getDetail(CustomerDetailGetParameter parameter);

    void delete(CustomerDeleteParameter parameter);

    IPage<CustomerDTO> getPage(CustomerPageGetParameter parameter);
    void enable(CustomerEnableParameter parameter);

    void disable(CustomerDisableParameter parameter);

    void save(CustomerSaveParameter parameter);

    void update(CustomerUpdateParameter parameter);

}

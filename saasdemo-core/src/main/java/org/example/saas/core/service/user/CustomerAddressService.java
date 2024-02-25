package org.example.saas.core.service.user;

import org.example.saas.core.pojo.CustomerAddress;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerAddressDTO;
import org.example.saas.core.parameter.user.CustomerAddressDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressPageGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressDeleteParameter;
import org.example.saas.core.parameter.user.CustomerAddressEnableParameter;
import org.example.saas.core.parameter.user.CustomerAddressDisableParameter;
import org.example.saas.core.parameter.user.CustomerAddressSaveParameter;
import org.example.saas.core.parameter.user.CustomerAddressUpdateParameter;
/**
 * <p>
 * 客户地址 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
public interface CustomerAddressService extends KutaBaseService<CustomerAddress> {

    CustomerAddressDTO getDetail(CustomerAddressDetailGetParameter parameter);

    void delete(CustomerAddressDeleteParameter parameter);

    IPage<CustomerAddressDTO> getPage(CustomerAddressPageGetParameter parameter);
    void enable(CustomerAddressEnableParameter parameter);

    void disable(CustomerAddressDisableParameter parameter);

    void save(CustomerAddressSaveParameter parameter);

    void update(CustomerAddressUpdateParameter parameter);

}

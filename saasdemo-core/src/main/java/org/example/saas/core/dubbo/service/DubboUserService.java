package org.example.saas.core.dubbo.service;


import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerGrowthIncreaseParameter;

public interface DubboUserService {

    /**
     * 获取客户信息
     * @param parameter
     * @return
     */
    CustomerDTO getCustomer(CustomerDetailGetParameter parameter);
    /**
     * 增加客户成长值
     * @param parameter
     * @return
     */
    void increaseGrowth(CustomerGrowthIncreaseParameter parameter);
}

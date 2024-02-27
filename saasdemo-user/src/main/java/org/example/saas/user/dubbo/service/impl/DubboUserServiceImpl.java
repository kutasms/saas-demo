package org.example.saas.user.dubbo.service.impl;


import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.dubbo.service.DubboUserService;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerGrowthIncreaseParameter;
import org.example.saas.core.service.user.CustomerService;

@DubboService
@RequiredArgsConstructor
public class DubboUserServiceImpl implements DubboUserService {

    private final CustomerService customerService;

    @Override
    public CustomerDTO getCustomer(CustomerDetailGetParameter parameter) {
        return customerService.getDetail(parameter);
    }

    @Override
    public void increaseGrowth(CustomerGrowthIncreaseParameter parameter) {
        customerService.increaseGrowth(parameter);
    }

}

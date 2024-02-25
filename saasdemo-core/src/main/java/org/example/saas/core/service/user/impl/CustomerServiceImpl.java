package org.example.saas.core.service.user.impl;

import org.example.saas.core.pojo.Customer;
import org.example.saas.core.mapper.CustomerMapper;
import org.example.saas.core.service.user.CustomerService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerPageGetParameter;
import org.example.saas.core.parameter.user.CustomerDeleteParameter;
import org.example.saas.core.parameter.user.CustomerSaveParameter;
import org.example.saas.core.parameter.user.CustomerUpdateParameter;
import org.example.saas.core.parameter.user.CustomerEnableParameter;
import org.example.saas.core.parameter.user.CustomerDisableParameter;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.chia.multienty.core.domain.constants.MultiTenantConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.chia.multienty.core.domain.enums.StatusEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultiTenantContext;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.chia.multienty.core.tools.IdWorkerProvider;
/**
 * <p>
 * 客户 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-25
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class CustomerServiceImpl extends KutaBaseServiceImpl<CustomerMapper, Customer> implements CustomerService {


    @Override
    public CustomerDTO getDetail(CustomerDetailGetParameter parameter) {
        return selectJoinOne(CustomerDTO.class,
                        MPJWrappers.<Customer>lambdaJoin()
                        .eq(Customer::getTenantId, parameter.getTenantId())
                        .eq(Customer::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void update(CustomerUpdateParameter parameter) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(parameter, customer);
        update(customer, new LambdaQueryWrapper<Customer>()
                .eq(Customer::getTenantId, parameter.getTenantId())
                .eq(Customer::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void delete(CustomerDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<Customer>()
                .eq(Customer::getTenantId, parameter.getTenantId())
                .eq(Customer::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public IPage<CustomerDTO> getPage(CustomerPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), CustomerDTO.class,
                new MTLambdaWrapper<Customer>()
                        .solveGenericParameters(parameter)
                        .eq(Customer::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getCustomerIds()),
                                Customer::getCustomerId,
                                parameter.getCustomerIds())
        );
    }

    @Override
    public void save(CustomerSaveParameter parameter) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(parameter, customer);
        customer.setCustomerId(IdWorkerProvider.next());

        saveTE(customer);
        customer.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setCustomerId(customer.getCustomerId());
    }


    @Override
    public void enable(CustomerEnableParameter parameter) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(parameter, customer);
        customer.setStatus(StatusEnum.NORMAL.getCode());
        update(customer, new LambdaQueryWrapper<Customer>()
                .eq(Customer::getTenantId, parameter.getTenantId())
                .eq(Customer::getCustomerId, parameter.getCustomerId()));

    }

    @Override
    public void disable(CustomerDisableParameter parameter) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(parameter, customer);
        customer.setStatus(StatusEnum.DISABLED.getCode());
        update(customer, new LambdaQueryWrapper<Customer>()
                .eq(Customer::getTenantId, parameter.getTenantId())
                .eq(Customer::getCustomerId, parameter.getCustomerId()));
    }
}
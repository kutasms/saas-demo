package org.example.saas.core.service.user.impl;

import com.chia.multienty.core.domain.enums.StatusEnum;
import org.example.saas.core.pojo.CustomerAddress;
import org.example.saas.core.mapper.CustomerAddressMapper;
import org.example.saas.core.service.user.CustomerAddressService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerAddressDTO;
import org.example.saas.core.parameter.user.CustomerAddressDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressPageGetParameter;
import org.example.saas.core.parameter.user.CustomerAddressDeleteParameter;
import org.example.saas.core.parameter.user.CustomerAddressSaveParameter;
import org.example.saas.core.parameter.user.CustomerAddressUpdateParameter;
import org.example.saas.core.parameter.user.CustomerAddressEnableParameter;
import org.example.saas.core.parameter.user.CustomerAddressDisableParameter;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.chia.multienty.core.domain.constants.MultiTenantConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultiTenantContext;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户地址 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class CustomerAddressServiceImpl extends KutaBaseServiceImpl<CustomerAddressMapper, CustomerAddress> implements CustomerAddressService {


    @Override
    public CustomerAddressDTO getDetail(CustomerAddressDetailGetParameter parameter) {
        return selectJoinOne(CustomerAddressDTO.class,
                        MPJWrappers.<CustomerAddress>lambdaJoin()
                        .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                        .eq(CustomerAddress::getAddressId, parameter.getAddressId()));
    }

    @Override
    public void update(CustomerAddressUpdateParameter parameter) {
        CustomerAddress customerAddress = new CustomerAddress();
        BeanUtils.copyProperties(parameter, customerAddress);
        update(customerAddress, new LambdaQueryWrapper<CustomerAddress>()
                .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                .eq(CustomerAddress::getAddressId, parameter.getAddressId()));
    }

    @Override
    public void delete(CustomerAddressDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<CustomerAddress>()
                .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                .eq(CustomerAddress::getAddressId, parameter.getAddressId()));
    }

    @Override
    public IPage<CustomerAddressDTO> getPage(CustomerAddressPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), CustomerAddressDTO.class,
                new MTLambdaWrapper<CustomerAddress>()
                        .solveGenericParameters(parameter)
                        .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getAddressIds()),
                                CustomerAddress::getAddressId,
                                parameter.getAddressIds())
        );
    }

    @Override
    public void save(CustomerAddressSaveParameter parameter) {
        CustomerAddress customerAddress = new CustomerAddress();
        BeanUtils.copyProperties(parameter, customerAddress);
        saveTE(customerAddress);
        customerAddress.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setAddressId(customerAddress.getAddressId());
    }


    @Override
    public void enable(CustomerAddressEnableParameter parameter) {
        CustomerAddress customerAddress = new CustomerAddress();
        BeanUtils.copyProperties(parameter, customerAddress);
        customerAddress.setStatus(StatusEnum.NORMAL.getCode());
        update(customerAddress, new LambdaQueryWrapper<CustomerAddress>()
                .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                .eq(CustomerAddress::getAddressId, parameter.getAddressId()));

    }

    @Override
    public void disable(CustomerAddressDisableParameter parameter) {
        CustomerAddress customerAddress = new CustomerAddress();
        BeanUtils.copyProperties(parameter, customerAddress);
        customerAddress.setStatus(StatusEnum.DISABLED.getCode());
        update(customerAddress, new LambdaQueryWrapper<CustomerAddress>()
                .eq(CustomerAddress::getTenantId, parameter.getTenantId())
                .eq(CustomerAddress::getAddressId, parameter.getAddressId()));
    }
}

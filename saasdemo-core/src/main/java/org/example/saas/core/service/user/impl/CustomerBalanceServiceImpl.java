package org.example.saas.core.service.user.impl;

import com.chia.multienty.core.domain.enums.StatusEnum;
import org.example.saas.core.pojo.CustomerBalance;
import org.example.saas.core.mapper.CustomerBalanceMapper;
import org.example.saas.core.service.user.CustomerBalanceService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerBalanceDTO;
import org.example.saas.core.parameter.user.CustomerBalanceDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerBalancePageGetParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDeleteParameter;
import org.example.saas.core.parameter.user.CustomerBalanceSaveParameter;
import org.example.saas.core.parameter.user.CustomerBalanceUpdateParameter;
import org.example.saas.core.parameter.user.CustomerBalanceEnableParameter;
import org.example.saas.core.parameter.user.CustomerBalanceDisableParameter;
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
 * 客户余额 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Service
@RequiredArgsConstructor
@DS(MultiTenantConstants.DS_SHARDING)
public class CustomerBalanceServiceImpl extends KutaBaseServiceImpl<CustomerBalanceMapper, CustomerBalance> implements CustomerBalanceService {


    @Override
    public CustomerBalanceDTO getDetail(CustomerBalanceDetailGetParameter parameter) {
        return selectJoinOne(CustomerBalanceDTO.class,
                        MPJWrappers.<CustomerBalance>lambdaJoin()
                        .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                        .eq(CustomerBalance::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void update(CustomerBalanceUpdateParameter parameter) {
        CustomerBalance customerBalance = new CustomerBalance();
        BeanUtils.copyProperties(parameter, customerBalance);
        update(customerBalance, new LambdaQueryWrapper<CustomerBalance>()
                .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                .eq(CustomerBalance::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void delete(CustomerBalanceDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<CustomerBalance>()
                .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                .eq(CustomerBalance::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public IPage<CustomerBalanceDTO> getPage(CustomerBalancePageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), CustomerBalanceDTO.class,
                new MTLambdaWrapper<CustomerBalance>()
                        .solveGenericParameters(parameter)
                        .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getCustomerIds()),
                                CustomerBalance::getCustomerId,
                                parameter.getCustomerIds())
        );
    }

    @Override
    public void save(CustomerBalanceSaveParameter parameter) {
        CustomerBalance customerBalance = new CustomerBalance();
        BeanUtils.copyProperties(parameter, customerBalance);
        saveTE(customerBalance);
        customerBalance.setTenantId(MultiTenantContext.getTenant().getTenantId());
        parameter.setCustomerId(customerBalance.getCustomerId());
    }


    @Override
    public void enable(CustomerBalanceEnableParameter parameter) {
        CustomerBalance customerBalance = new CustomerBalance();
        BeanUtils.copyProperties(parameter, customerBalance);
        customerBalance.setStatus(StatusEnum.NORMAL.getCode());
        update(customerBalance, new LambdaQueryWrapper<CustomerBalance>()
                .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                .eq(CustomerBalance::getCustomerId, parameter.getCustomerId()));

    }

    @Override
    public void disable(CustomerBalanceDisableParameter parameter) {
        CustomerBalance customerBalance = new CustomerBalance();
        BeanUtils.copyProperties(parameter, customerBalance);
        customerBalance.setStatus(StatusEnum.DISABLED.getCode());
        update(customerBalance, new LambdaQueryWrapper<CustomerBalance>()
                .eq(CustomerBalance::getTenantId, parameter.getTenantId())
                .eq(CustomerBalance::getCustomerId, parameter.getCustomerId()));
    }
}

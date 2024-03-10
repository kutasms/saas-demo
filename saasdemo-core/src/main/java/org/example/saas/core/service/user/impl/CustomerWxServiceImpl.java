package org.example.saas.core.service.user.impl;

import com.chia.multienty.core.domain.enums.StatusEnum;
import org.example.saas.core.pojo.CustomerWx;
import org.example.saas.core.mapper.CustomerWxMapper;
import org.example.saas.core.service.user.CustomerWxService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerWxDTO;
import org.example.saas.core.parameter.user.CustomerWxDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerWxPageGetParameter;
import org.example.saas.core.parameter.user.CustomerWxDeleteParameter;
import org.example.saas.core.parameter.user.CustomerWxSaveParameter;
import org.example.saas.core.parameter.user.CustomerWxUpdateParameter;
import org.example.saas.core.parameter.user.CustomerWxEnableParameter;
import org.example.saas.core.parameter.user.CustomerWxDisableParameter;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import com.chia.multienty.core.domain.constants.MultientyConstants;
import com.chia.multienty.core.mybatis.MTLambdaWrapper;
import com.chia.multienty.core.util.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chia.multienty.core.tools.MultientyContext;
import com.baomidou.dynamic.datasource.annotation.DS;

/**
 * <p>
 * 客户微信 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Service
@RequiredArgsConstructor
@DS(MultientyConstants.DS_SHARDING)
public class CustomerWxServiceImpl extends KutaBaseServiceImpl<CustomerWxMapper, CustomerWx> implements CustomerWxService {


    @Override
    public CustomerWxDTO getDetail(CustomerWxDetailGetParameter parameter) {
        return selectJoinOne(CustomerWxDTO.class,
                        MPJWrappers.<CustomerWx>lambdaJoin()
                        .eq(CustomerWx::getTenantId, parameter.getTenantId())
                        .eq(CustomerWx::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void update(CustomerWxUpdateParameter parameter) {
        CustomerWx customerWx = new CustomerWx();
        BeanUtils.copyProperties(parameter, customerWx);
        update(customerWx, new LambdaQueryWrapper<CustomerWx>()
                .eq(CustomerWx::getTenantId, parameter.getTenantId())
                .eq(CustomerWx::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public void delete(CustomerWxDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<CustomerWx>()
                .eq(CustomerWx::getTenantId, parameter.getTenantId())
                .eq(CustomerWx::getCustomerId, parameter.getCustomerId()));
    }

    @Override
    public IPage<CustomerWxDTO> getPage(CustomerWxPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), CustomerWxDTO.class,
                new MTLambdaWrapper<CustomerWx>()
                        .solveGenericParameters(parameter)
                        .eq(CustomerWx::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getCustomerIds()),
                                CustomerWx::getCustomerId,
                                parameter.getCustomerIds())
        );
    }

    @Override
    public void save(CustomerWxSaveParameter parameter) {
        CustomerWx customerWx = new CustomerWx();
        BeanUtils.copyProperties(parameter, customerWx);
        saveTE(customerWx);
        customerWx.setTenantId(MultientyContext.getTenant().getTenantId());
        parameter.setCustomerId(customerWx.getCustomerId());
    }


    @Override
    public void enable(CustomerWxEnableParameter parameter) {
        CustomerWx customerWx = new CustomerWx();
        BeanUtils.copyProperties(parameter, customerWx);
        customerWx.setStatus(StatusEnum.NORMAL.getCode());
        update(customerWx, new LambdaQueryWrapper<CustomerWx>()
                .eq(CustomerWx::getTenantId, parameter.getTenantId())
                .eq(CustomerWx::getCustomerId, parameter.getCustomerId()));

    }

    @Override
    public void disable(CustomerWxDisableParameter parameter) {
        CustomerWx customerWx = new CustomerWx();
        BeanUtils.copyProperties(parameter, customerWx);
        customerWx.setStatus(StatusEnum.DISABLED.getCode());
        update(customerWx, new LambdaQueryWrapper<CustomerWx>()
                .eq(CustomerWx::getTenantId, parameter.getTenantId())
                .eq(CustomerWx::getCustomerId, parameter.getCustomerId()));
    }
}

package org.example.saas.core.service.user.impl;

import org.example.saas.core.pojo.BalanceBill;
import org.example.saas.core.mapper.BalanceBillMapper;
import org.example.saas.core.service.user.BalanceBillService;
import com.chia.multienty.core.mybatis.service.impl.KutaBaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.BalanceBillDTO;
import org.example.saas.core.parameter.user.BalanceBillDetailGetParameter;
import org.example.saas.core.parameter.user.BalanceBillPageGetParameter;
import org.example.saas.core.parameter.user.BalanceBillDeleteParameter;
import org.example.saas.core.parameter.user.BalanceBillSaveParameter;
import org.example.saas.core.parameter.user.BalanceBillUpdateParameter;
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
 * 余额账单 服务实现类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
@Service
@RequiredArgsConstructor
@DS(MultientyConstants.DS_SHARDING)
public class BalanceBillServiceImpl extends KutaBaseServiceImpl<BalanceBillMapper, BalanceBill> implements BalanceBillService {


    @Override
    public BalanceBillDTO getDetail(BalanceBillDetailGetParameter parameter) {
        return selectJoinOne(BalanceBillDTO.class,
                        MPJWrappers.<BalanceBill>lambdaJoin()
                        .eq(BalanceBill::getTenantId, parameter.getTenantId())
                        .eq(BalanceBill::getBillId, parameter.getBillId()));
    }

    @Override
    public void update(BalanceBillUpdateParameter parameter) {
        BalanceBill balanceBill = new BalanceBill();
        BeanUtils.copyProperties(parameter, balanceBill);
        update(balanceBill, new LambdaQueryWrapper<BalanceBill>()
                .eq(BalanceBill::getTenantId, parameter.getTenantId())
                .eq(BalanceBill::getBillId, parameter.getBillId()));
    }

    @Override
    public void delete(BalanceBillDeleteParameter parameter) {
        removeTE(new LambdaQueryWrapper<BalanceBill>()
                .eq(BalanceBill::getTenantId, parameter.getTenantId())
                .eq(BalanceBill::getBillId, parameter.getBillId()));
    }

    @Override
    public IPage<BalanceBillDTO> getPage(BalanceBillPageGetParameter parameter) {
        return selectJoinListPage(parameter.getPageObj(), BalanceBillDTO.class,
                new MTLambdaWrapper<BalanceBill>()
                        .solveGenericParameters(parameter)
                        .eq(BalanceBill::getTenantId, parameter.getTenantId())
                        .in(!ListUtil.isEmpty(parameter.getBillIds()),
                                BalanceBill::getBillId,
                                parameter.getBillIds())
        );
    }

    @Override
    public void save(BalanceBillSaveParameter parameter) {
        BalanceBill balanceBill = new BalanceBill();
        BeanUtils.copyProperties(parameter, balanceBill);
        saveTE(balanceBill);
        balanceBill.setTenantId(MultientyContext.getTenant().getTenantId());
        parameter.setBillId(balanceBill.getBillId());
    }


}

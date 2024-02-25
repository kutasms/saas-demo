package org.example.saas.core.service.user;

import org.example.saas.core.pojo.CustomerWx;
import com.chia.multienty.core.mybatis.service.KutaBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.saas.core.domain.dto.CustomerWxDTO;
import org.example.saas.core.parameter.user.CustomerWxDetailGetParameter;
import org.example.saas.core.parameter.user.CustomerWxPageGetParameter;
import org.example.saas.core.parameter.user.CustomerWxDeleteParameter;
import org.example.saas.core.parameter.user.CustomerWxEnableParameter;
import org.example.saas.core.parameter.user.CustomerWxDisableParameter;
import org.example.saas.core.parameter.user.CustomerWxSaveParameter;
import org.example.saas.core.parameter.user.CustomerWxUpdateParameter;
/**
 * <p>
 * 客户微信 服务类
 * </p>
 *
 * @author Multi Tenant Auto Generator
 * @since 2024-02-24
 */
public interface CustomerWxService extends KutaBaseService<CustomerWx> {

    CustomerWxDTO getDetail(CustomerWxDetailGetParameter parameter);

    void delete(CustomerWxDeleteParameter parameter);

    IPage<CustomerWxDTO> getPage(CustomerWxPageGetParameter parameter);
    void enable(CustomerWxEnableParameter parameter);

    void disable(CustomerWxDisableParameter parameter);

    void save(CustomerWxSaveParameter parameter);

    void update(CustomerWxUpdateParameter parameter);

}

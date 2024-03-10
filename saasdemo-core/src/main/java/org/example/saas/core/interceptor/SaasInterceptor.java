package org.example.saas.core.interceptor;

import com.chia.multienty.core.domain.basic.Result;
import com.chia.multienty.core.domain.constants.MultientyHeaderConstants;
import com.chia.multienty.core.properties.yaml.YamlMultientyProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.example.saas.core.domain.constants.SaasConstants;
import org.example.saas.core.domain.dto.CustomerDTO;
import org.example.saas.core.dubbo.service.DubboUserService;
import org.example.saas.core.parameter.user.CustomerDetailGetParameter;
import org.example.saas.core.tools.CustomerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SaasInterceptor implements HandlerInterceptor {

    @Autowired
    private DubboUserService dubboUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        response.setHeader("Content-Type", "json/application; charset=utf-8");
        Result result = null;
        String strTenantId = request.getHeader(MultientyHeaderConstants.TENANT_ID_KEY);
        Long tenantId = Long.parseLong(strTenantId);
        String mockCustomerId = request.getHeader(SaasConstants.MOCK_CUSTOMER_ID);

        if(Strings.isNotEmpty(mockCustomerId)) {
            CustomerDTO customer = dubboUserService.getCustomer(new CustomerDetailGetParameter()
                    .setTenantId(tenantId).setCustomerId(Long.parseLong(mockCustomerId)));
            CustomerContext.setCustomer(customer);
        }
        return true;
    }
}

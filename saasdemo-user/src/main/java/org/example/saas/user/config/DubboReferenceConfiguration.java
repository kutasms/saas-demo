package org.example.saas.user.config;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.example.saas.core.dubbo.service.DubboMasterService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "dubbo", name = "enabled", havingValue = "true")
public class DubboReferenceConfiguration {

    @Bean
    @DubboReference(timeout = 5000)
    public ReferenceBean<DubboMasterService> dubboMasterServiceReferenceBean() {
        return new ReferenceBean<>();
    }

    @Bean
    public DubboMasterService dubboMasterService(ReferenceBean<DubboMasterService> dubboMasterServiceReferenceBean) {
        DubboMasterService dubboMasterService = dubboMasterServiceReferenceBean.getObject();
        return dubboMasterService;
    }
}

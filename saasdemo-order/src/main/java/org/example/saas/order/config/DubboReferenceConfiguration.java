package org.example.saas.order.config;


import com.chia.multienty.core.dubbo.service.DubboWechatService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.example.saas.core.dubbo.service.DubboMasterService;
import org.example.saas.core.dubbo.service.DubboUserService;
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

    @Bean
    @DubboReference(timeout = 5000)
    public ReferenceBean<DubboUserService> dubboUserServiceReferenceBean() {
        return new ReferenceBean<>();
    }

    @Bean
    public DubboUserService dubboUserService(ReferenceBean<DubboUserService> dubboUserServiceReferenceBean) {
        DubboUserService dubboUserService = dubboUserServiceReferenceBean.getObject();
        return dubboUserService;
    }

}

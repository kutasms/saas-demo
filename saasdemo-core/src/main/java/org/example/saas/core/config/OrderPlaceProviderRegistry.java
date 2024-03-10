package org.example.saas.core.config;


import com.chia.multienty.core.tools.MultientyServiceLoader;
import org.example.saas.core.domain.constants.SaasConstants;
import org.example.saas.core.service.order.strategy.IOrderPlaceProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Collection;

public class OrderPlaceProviderRegistry implements BeanDefinitionRegistryPostProcessor {


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        MultientyServiceLoader.register(IOrderPlaceProvider.class);

        Collection<IOrderPlaceProvider> providers = MultientyServiceLoader.getInstances(IOrderPlaceProvider.class);
        for (IOrderPlaceProvider provider : providers) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(provider.getClass());
            registry.registerBeanDefinition(SaasConstants.ORDER_PLACE_PROVIDER_PREFIX + provider.getType().name(), builder.getBeanDefinition());
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}

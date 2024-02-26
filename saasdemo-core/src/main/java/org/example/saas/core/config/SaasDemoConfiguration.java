package org.example.saas.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaasDemoConfiguration {
    @Bean
    public static OrderPlaceProviderRegistry orderPlaceProviderRegistry() {
        return new OrderPlaceProviderRegistry();
    }
}

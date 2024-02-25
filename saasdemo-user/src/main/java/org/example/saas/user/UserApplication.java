package org.example.saas.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {
        "com.chia.multienty.core",
        "org.example.saas.core",
        "org.example.saas.user",
})
@EnableDubbo
@MapperScan(value={"com.chia.multienty.core.mapper","org.example.saas.core.mapper"})
public class UserApplication {
    public static void main(String[] args) {
        System.setProperty("dubbo.application.logger","slf4j");
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);

    }
}
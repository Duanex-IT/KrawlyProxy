package com.usb.proxy.krawly.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.usb.proxy.krawly")
@PropertySources({
        @PropertySource("classpath:krawly.proxy.properties"),
        @PropertySource(value = "file:/opt/esb/config/krawly.proxy.properties", ignoreResourceNotFound = true)
})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
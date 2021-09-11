package com.sda.spring.boot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

    @Autowired
    public Environment env;

    @Bean
    public CustomProperties customProperties() {
        CustomProperties customProperties = new CustomProperties();
        customProperties.setAppOwner(env.getProperty("appOwner"));
        customProperties.setReleaseVersion(env.getProperty("releaseVersion"));
        return customProperties;
    }
}

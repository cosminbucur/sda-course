package com.sda.spring.boot.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// https://www.journaldev.com/21448/spring-value-annotation#spring-value-8211-default-value
@Component
@PropertySource("classpath:application.yml")
public class PropertyReader {

    // property binding
    // read from file : default value
    @Value("${appOwner:unknown}")
    private String appOwner;

    // read system environment variables when spring evn is populated
    @Value("${java.home}")
    private String javaHome;

    @Override
    public String toString() {
        return "PropertyReader{" +
                "appOwner='" + appOwner + '\'' +
                ", javaHome='" + javaHome + '\'' +
                '}';
    }
}

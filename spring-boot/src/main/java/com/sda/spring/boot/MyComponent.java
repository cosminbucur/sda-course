package com.sda.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private static final Logger logger = LoggerFactory.getLogger(MyComponent.class);

    public String complexOperation() {
        logger.info("--- in complex operation");
        return "ok";
    }
}

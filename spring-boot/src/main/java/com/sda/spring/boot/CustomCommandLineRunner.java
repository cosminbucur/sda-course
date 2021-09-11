package com.sda.spring.boot;

import com.sda.spring.boot.logging.LoggerComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CustomCommandLineRunner.class);

    @Autowired
    private MyComponent myComponent;

    @Autowired
    private LoggerComponent loggerComponent;

    @Override
    public void run(String... args) {
        log.info("--- in custom command line runner");
        myComponent.complexOperation();

        loggerComponent.testLoggingLevels();
    }
}

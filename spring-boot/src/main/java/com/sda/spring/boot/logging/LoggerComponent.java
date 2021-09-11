package com.sda.spring.boot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerComponent {

    private static final Logger log = LoggerFactory.getLogger(LoggerComponent.class);

    /**
     * ERROR (highest)
     * WARN
     * INFO
     * DEBUG
     * TRACE
     */
    public void testLoggingLevels() {
        int firstParam = 10;
        String secondParam = "issues";
        log.error("error message with {} {}", firstParam, secondParam);
        log.warn("warn message");
        log.info("info message");
        log.debug("debug message");
        log.trace("trace message");
    }
}

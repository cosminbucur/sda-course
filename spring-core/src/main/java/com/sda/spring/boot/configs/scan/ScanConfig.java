package com.sda.spring.boot.configs.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.sda.spring.core.configs.scan"})
@Configuration
public class ScanConfig {
}

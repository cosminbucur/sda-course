package com.sda.spring.boot.qualifier;

import org.springframework.stereotype.Component;

@Component("barFormatter")
public class BarFormatter implements Formatter {

    @Override
    public String format() {
        System.out.println("bar");
        return "bar";
    }
}

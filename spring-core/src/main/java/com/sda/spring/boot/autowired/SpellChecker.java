package com.sda.spring.boot.autowired;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    public void checkSpelling() {
        System.out.println("check spelling...");
    }
}

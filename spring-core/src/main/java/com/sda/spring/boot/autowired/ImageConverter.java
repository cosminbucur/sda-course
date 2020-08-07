package com.sda.spring.boot.autowired;

import org.springframework.stereotype.Component;

@Component
public class ImageConverter {

    public void convert() {
        System.out.println("convert...");
    }
}

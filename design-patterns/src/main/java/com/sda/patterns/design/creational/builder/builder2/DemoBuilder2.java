package com.sda.patterns.design.creational.builder.builder2;

import java.time.Year;

public class DemoBuilder2 {

    public static void main(String[] args) {
        Book.Builder builder = new Book.Builder("123", "title");
        builder.author("author")
                .description("description")
                .published(Year.now())
                .build();
    }
}

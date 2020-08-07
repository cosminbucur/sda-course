package com.bucur.builder;

public class DemoBuilder {

    public static void main(String[] args) {
        Address address = new Address.AddressBuilder()
            .county("bucharest")
            .build();
    }
}

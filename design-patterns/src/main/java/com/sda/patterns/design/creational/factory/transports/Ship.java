package com.sda.patterns.design.creational.factory.transports;

public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("ship delivering");
    }
}

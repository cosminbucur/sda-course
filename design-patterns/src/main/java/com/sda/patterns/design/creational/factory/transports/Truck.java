package com.sda.patterns.design.creational.factory.transports;

public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("truck delivering");
    }
}

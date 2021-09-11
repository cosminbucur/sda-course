package com.bucur.patterns.creational.factory.transports;

public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("ship delivering");
    }
}

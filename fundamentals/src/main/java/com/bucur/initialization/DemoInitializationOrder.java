package com.bucur.initialization;

public class DemoInitializationOrder {

    public static void main(String[] args) {
        new Spike();
        new Spike(8);
    }
}


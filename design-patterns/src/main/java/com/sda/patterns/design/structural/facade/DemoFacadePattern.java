package com.sda.patterns.design.structural.facade;

public class DemoFacadePattern {

    public static void main(String[] args) {
        CarEngineFacade facade = new CarEngineFacade();
        facade.startEngine();

        facade.stopEngine();
    }
}

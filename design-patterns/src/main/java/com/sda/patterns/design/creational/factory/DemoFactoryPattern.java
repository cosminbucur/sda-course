package com.sda.patterns.design.creational.factory;

import com.sda.patterns.design.creational.factory.factory.Logistics;
import com.sda.patterns.design.creational.factory.factory.RoadLogistics;
import com.sda.patterns.design.creational.factory.factory.SeaLogistics;

public class DemoFactoryPattern {

    private static Logistics factory;

    public static void main(String[] args) throws Exception {
        initialize("truck");
        factory.planDelivery();
    }

    private static void initialize(String input) throws Exception {
        if (input.equals("truck")) {
            factory = new RoadLogistics();
        } else if (input.equals("ship")) {
            factory = new SeaLogistics();
        } else {
            throw new Exception("unknown transport");
        }
    }
}


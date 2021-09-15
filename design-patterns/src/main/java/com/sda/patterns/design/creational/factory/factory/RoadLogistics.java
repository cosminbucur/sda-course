package com.sda.patterns.design.creational.factory.factory;

import com.sda.patterns.design.creational.factory.transports.Transport;
import com.sda.patterns.design.creational.factory.transports.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

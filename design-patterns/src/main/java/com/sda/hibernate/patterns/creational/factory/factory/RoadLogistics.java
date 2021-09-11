package com.bucur.patterns.creational.factory.factory;

import com.bucur.patterns.creational.factory.transports.Transport;
import com.bucur.patterns.creational.factory.transports.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

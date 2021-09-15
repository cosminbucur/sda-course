package com.sda.patterns.design.creational.factory.factory;

import com.sda.patterns.design.creational.factory.transports.Ship;
import com.sda.patterns.design.creational.factory.transports.Transport;

public class SeaLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

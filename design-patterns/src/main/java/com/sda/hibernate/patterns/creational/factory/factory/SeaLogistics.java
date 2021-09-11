package com.bucur.patterns.creational.factory.factory;

import com.bucur.patterns.creational.factory.transports.Ship;
import com.bucur.patterns.creational.factory.transports.Transport;

public class SeaLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

package com.sda.patterns.design.creational.factory.factory;

import com.sda.patterns.design.creational.factory.transports.Transport;

public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    abstract Transport createTransport();
}

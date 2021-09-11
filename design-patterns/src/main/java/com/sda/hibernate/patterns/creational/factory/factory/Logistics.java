package com.bucur.patterns.creational.factory.factory;

import com.bucur.patterns.creational.factory.transports.Transport;

public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    abstract Transport createTransport();
}

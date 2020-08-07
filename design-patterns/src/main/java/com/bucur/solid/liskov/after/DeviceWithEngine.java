package com.bucur.solid.liskov.after;

import com.bucur.solid.liskov.before.Engine;

public class DeviceWithEngine extends TransportationDevice {

    private Engine engine;

    void startEngine() {
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

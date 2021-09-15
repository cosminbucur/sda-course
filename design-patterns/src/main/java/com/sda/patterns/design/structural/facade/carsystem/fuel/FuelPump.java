package com.sda.patterns.design.structural.facade.carsystem.fuel;

import java.util.logging.Logger;

// TODO: 7. create fuel pump
public class FuelPump {

    private static final Logger logger = Logger.getLogger(FuelPump.class.getName());

    public void pump() {
        logger.info("Fuel Pump is pumping fuel..");
    }
}

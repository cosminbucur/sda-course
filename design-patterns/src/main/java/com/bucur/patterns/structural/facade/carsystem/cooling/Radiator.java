package com.bucur.patterns.structural.facade.carsystem.cooling;

import java.util.logging.Logger;

// TODO: 2. create component of cooling system
public class Radiator {

    private static final Logger logger = Logger.getLogger(Radiator.class.getName());

    public void on() {
        logger.info("Radiator switched on!");
    }

    public void off() {
        logger.info("Radiator switched off!");
    }

    public void setSpeed(Integer speed) {
        logger.info("Setting radiator speed to " + speed);
    }
}

package com.sda.patterns.design.structural.facade.carsystem;

import java.util.logging.Logger;

// TODO: 8. create catalytic converter
public class CatalyticConverter {

    private static final Logger logger = Logger.getLogger(CatalyticConverter.class.getName());

    public void on() {
        logger.info("Catalytic Converter switched on!");
    }

    public void off() {
        logger.info("Catalytic Converter switched off!");
    }
}

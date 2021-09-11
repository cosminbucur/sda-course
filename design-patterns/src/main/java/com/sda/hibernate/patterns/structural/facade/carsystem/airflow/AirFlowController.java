package com.bucur.patterns.structural.facade.carsystem.airflow;

import java.util.logging.Logger;

// TODO: 4. create cooling system
public class AirFlowController {

    private static final Logger logger = Logger.getLogger(AirFlowController.class.getName());

    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        airFlowMeter.getMeasurements();
        logger.info("Air provided!");
    }

    public void off() {
        logger.info("Air controller switched off.");
    }
}

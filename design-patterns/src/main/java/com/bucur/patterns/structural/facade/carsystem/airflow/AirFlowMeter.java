package com.bucur.patterns.structural.facade.carsystem.airflow;

import java.util.logging.Logger;

// TODO: 5. create cooling system
public class AirFlowMeter {

    private static final Logger logger = Logger.getLogger(AirFlowMeter.class.getName());

    public void getMeasurements() {
        logger.info("Getting air measurements..");
    }
}

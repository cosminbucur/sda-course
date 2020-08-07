package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoPropertyChangeListener extends Application {

    private static void usePropertyChangeListener() {
        // Creates a String property
        SimpleStringProperty stringProperty = new SimpleStringProperty("xyz");
        // Prints property's value
        System.out.println(stringProperty.getValue());
        // Adds a listener - action that will be run if property's value changes.
        stringProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("New value is set: " + newValue);
        });
        // Sets new value
        stringProperty.setValue("Some new value");
    }

    @Override
    public void start(Stage primaryStage) {
        usePropertyChangeListener();
    }
}

package com.sda.javafx.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoUnidirectionalBinding extends Application {

    private static void useUnidirectionalBinding() {
        SimpleStringProperty property1 = new SimpleStringProperty("xyz");
        SimpleStringProperty property2 = new SimpleStringProperty();
        // Unidirectional binding of property1 and property2.
        // Property2 will follow property1 value.
        property2.bind(property1);
        // Changing property1 value
        property1.setValue("Some new value");
        // will change property2 value as well.
        System.out.println(property2.getValue());
    }

    @Override
    public void start(Stage primaryStage) {
        useUnidirectionalBinding();
    }
}

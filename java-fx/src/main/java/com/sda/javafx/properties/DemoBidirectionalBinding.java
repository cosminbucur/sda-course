package com.sda.javafx.properties;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class DemoBidirectionalBinding extends Application {

    private static void useBidirectionalBinding() {
        SimpleStringProperty property1 = new SimpleStringProperty();
        SimpleStringProperty property2 = new SimpleStringProperty();
        // Bidirectional binding of property1 and property2.
        property2.bindBidirectional(property1);
        // Changing property1 value
        property1.setValue("Some new value");
        // will change property2 value as well.
        System.out.println(property2.getValue());
        // Analogically:
        property2.setValue("Some other new value");
        System.out.println(property1.getValue());
    }

    @Override
    public void start(Stage primaryStage) {
        useBidirectionalBinding();
    }
}

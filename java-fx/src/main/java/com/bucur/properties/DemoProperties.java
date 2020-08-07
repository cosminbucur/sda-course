package com.bucur.properties;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoProperties extends Application {

    private static VBox buildVBoxWithProperties() {
        VBox vBox = new VBox();
        TextField textField = new TextField("Initial text value");
        textField.getText();
        textField.setText("New value");

        // represents the value with the addition of event handlers regarding that value
        StringProperty textProperty = textField.textProperty();

        vBox.getChildren().addAll(textField);
        return vBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = buildVBoxWithProperties();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

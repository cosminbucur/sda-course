package com.bucur.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoEventArgument extends Application {

    private static VBox buildVBoxWithEventArgument() {
        TextField textField = new TextField();
        // Prints the key code in the console if the key is pressed
        textField.setOnKeyPressed(event -> System.out.println(event.getCode()));

        VBox vBox = new VBox();
        vBox.getChildren().add(textField);
        return vBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = buildVBoxWithEventArgument();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

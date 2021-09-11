package com.sda.javafx.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoActionEvents extends Application {

    private static VBox buildVBoxWithActionEvent() {
        Button button = new Button("Press me");
        button.setOnAction(event -> System.out.println("Click!"));
        VBox vBox = new VBox();
        vBox.getChildren().add(button);
        return vBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = buildVBoxWithActionEvent();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

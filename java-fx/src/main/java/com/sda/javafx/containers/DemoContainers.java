package com.sda.javafx.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoContainers extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        // Creating the container object
        VBox vBox = new VBox();

        // Creating a label control. Constructor argument represents displayed text.
        Label label = new Label("Hello world!");

        // Setting label to be a child of the vBox container
        vBox.getChildren().add(label);

        // Creating a scene. The vBox is passed as it's root.
        Scene scene = new Scene(vBox);

        // Setting the main window's scene.
        primaryStage.setScene(scene);

        // Showing the window.
        primaryStage.show();
    }

}

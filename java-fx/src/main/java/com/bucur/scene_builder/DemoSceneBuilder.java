package com.bucur.scene_builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoSceneBuilder extends Application {

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = buildSceneFromFxml();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Scene buildSceneFromFxml() throws IOException {
        // If the fxml file is located in the same package:
//        Parent root = FXMLLoader.load(getClass().getResource("../../../../resources/view.fxml"));
        // For a maven project (view.fxml located in the resources folder):
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui.fxml"));

        Scene scene = new Scene(root);
        return scene;
    }

}

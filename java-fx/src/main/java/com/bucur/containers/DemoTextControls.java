package com.bucur.containers;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoTextControls extends Application {

    private static VBox buildTextControls() {
        VBox root = new VBox();

        Button button = new Button("button");
        button.getText();

        TextField textField = new TextField("text field");
        textField.getText();

        TextArea textArea = new TextArea("text area");
        textArea.getText();

        Label label = new Label("label");
        label.getText();

        CheckBox checkBox = new CheckBox("Tick me!");
        System.out.println(checkBox.getText());

        root.getChildren().addAll(button, textField, textArea, label, checkBox);
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = buildTextControls();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package com.bucur.properties;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoControlsPropertyBinding extends Application {

    private static VBox useControlPropertyBinding() {
        TextField textField = new TextField();
        Label label = new Label();
        textField.textProperty().bindBidirectional(label.textProperty());

        VBox vBox = new VBox();
        ObservableList<Node> children = vBox.getChildren();
        children.add(textField);
        children.add(label);

        return vBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = useControlPropertyBinding();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

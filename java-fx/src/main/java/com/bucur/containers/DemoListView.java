package com.bucur.containers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoListView extends Application {

    private static VBox buildListView() {
        // multi-line element (a list of objects)
        ListView<String> listView = new ListView<>();

        ObservableList<String> items = listView.getItems();
        items.add("Element 1");
        items.add("Element 2");
        items.add("Element 3");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);
        return vBox;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = buildListView();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

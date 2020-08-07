package com.bucur.properties;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DemoSliderPropertyBinding extends Application {

    private static VBox useSliderPropertyBinding() {
        Slider slider = new Slider();
        VBox root = new VBox();

        // slider value affects the space between itself and the label
        root.spacingProperty().bind(slider.valueProperty());

        ObservableList<Node> rootChildren = root.getChildren();
        rootChildren.add(slider);
        rootChildren.add(new Label("abc"));

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = useSliderPropertyBinding();
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

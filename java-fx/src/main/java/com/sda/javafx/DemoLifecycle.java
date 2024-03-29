package com.sda.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

public class DemoLifecycle extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Initializing app");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Starting app");
        // ...
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping app");
    }
}

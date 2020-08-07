package com.bucur.patterns.creational.abstract_factory;

import com.bucur.patterns.creational.abstract_factory.factory.GUIFactory;
import com.bucur.patterns.creational.abstract_factory.factory.MacFactory;
import com.bucur.patterns.creational.abstract_factory.factory.WinFactory;

public class DemoAbstractFactory {

    public static void main(String[] args) throws Exception {
        GUIFactory factory;

        String os = "win";

        if (os == "win") {
            factory = new WinFactory();
        } else if (os == "mac") {
            factory = new MacFactory();
        } else {
            throw new Exception("Error: Unknown operating system");
        }

        Application application = new Application(factory);
        application.createUI();
        application.paint();
    }
}


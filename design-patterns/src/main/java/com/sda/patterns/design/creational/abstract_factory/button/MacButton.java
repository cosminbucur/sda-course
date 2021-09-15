package com.sda.patterns.design.creational.abstract_factory.button;

public class MacButton implements Button {

    @Override
    public void paint() {
        // Render a button in macOS style
        System.out.println("paint mac button");
    }
}

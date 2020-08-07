package com.bucur.fluent.ex1;

public class Arsalan implements IRestaurant {

    String name;
    String IMenu;

    @Override
    public IRestaurant name(String name) {
        this.name = name;
        System.out.println("Enter to hotel :: " + name);
        return this;
    }

    @Override
    public IMenu show() {
        ArsalanMenuHandler handler = new ArsalanMenuHandler();
        handler.showMenu();
        return handler;
    }
}

package com.bucur.fluent.ex1;

import java.util.ArrayList;
import java.util.List;

public class ArsalanMenuHandler implements IMenu {

    List<IItem> menuList = new ArrayList<>();
    List<IItem> selectedList = new ArrayList<>();

    public ArsalanMenuHandler() {

    }

    @Override
    public IMenu order(int index) {
        return null;
    }

    @Override
    public IMenu eat() {
        return null;
    }

    @Override
    public IMenu pay() {
        return null;
    }

    @Override
    public IItem get(int index) {
        return null;
    }

    public void showMenu() {
        System.out.println("MENU IN ARSALAN");
        for (IItem item : menuList) {
            item.name();
        }
    }
}

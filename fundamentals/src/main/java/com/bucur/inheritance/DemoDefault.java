package com.bucur.inheritance;

public class DemoDefault {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.defaultField = "";

        Child child = new Child();
        child.defaultField = "";
        child.protectedField = "";
    }
}

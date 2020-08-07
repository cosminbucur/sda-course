package com.bucur.inheritance;

public class DemoAccessModifiersWithInheritance {

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        child.testFieldsFromParent();
    }
}

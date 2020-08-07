package com.bucur;

import com.bucur.inheritance.Parent;

public class OutsideClass {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.publicField = "hello";
    }
}

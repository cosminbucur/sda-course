package com.sda.advanced.oop.ex1;

public abstract class Course {

    private String name;

    public Course(String name) {
        this.name = name;
    }

    public abstract boolean passed();
}

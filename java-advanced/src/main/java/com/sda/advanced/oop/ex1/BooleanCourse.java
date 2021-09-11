package com.sda.advanced.oop.ex1;

public class BooleanCourse extends Course {

    private boolean grade;

    public BooleanCourse(String name, boolean grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    public boolean passed() {
        return grade;
    }
}

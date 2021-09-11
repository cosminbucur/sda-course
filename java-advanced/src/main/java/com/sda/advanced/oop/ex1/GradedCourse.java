package com.sda.advanced.oop.ex1;

public class GradedCourse extends Course {

    private int grade;

    public GradedCourse(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    @Override
    public boolean passed() {
        return grade >= 5;
    }
}

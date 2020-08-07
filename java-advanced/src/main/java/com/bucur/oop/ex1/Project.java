package com.bucur.oop.ex1;

public class Project {

    private Course course1;
    private Course course2;

    public Project(Course course1, Course course2) {
        this.course1 = course1;
        this.course2 = course2;
    }

    public boolean passed() {
        return course1.passed() && course2.passed();
    }
}

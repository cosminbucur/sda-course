package com.sda.advanced.oop.ex1;

public class DemoEx1 {

    public static void main(String[] args) {
        Course course1 = new BooleanCourse("math", true);
        Course course2 = new GradedCourse("programming", 9);

        Project project = new Project(course1, course2);

        System.out.println("project passed: " + project.passed());
    }
}

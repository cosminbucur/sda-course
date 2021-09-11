package com.sda.advanced.oop.ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoLambdaTest {

    @Test
    public void given1PassedAnd1Grade4_shouldFail() {
        Course course1 = new BooleanCourse("math", true);
        Course course2 = new GradedCourse("programming", 4);

        Project project = new Project(course1, course2);

        assertThat(project.passed()).isFalse();
    }

    @Test
    public void given1FailedAnd1Passed_shouldFail() {
        Course course1 = new BooleanCourse("math", false);
        Course course2 = new GradedCourse("programming", 5);

        Project project = new Project(course1, course2);

        assertThat(project.passed()).isFalse();
    }

    @Test
    public void given2Passed_shouldPass() {
        Course course1 = new BooleanCourse("math", true);
        Course course2 = new GradedCourse("programming", 9);

        Project project = new Project(course1, course2);

        assertThat(project.passed()).isTrue();
    }
}
package com.bucur.relationships.aggregation;

import java.util.ArrayList;
import java.util.List;

public class DemoAggregation {

    public static void main(String[] args) {
        Student s1 = new Student("Mia", 1, "CSE");
        Student s2 = new Student("Priya", 2, "CSE");
        Student s3 = new Student("John", 1, "EE");
        Student s4 = new Student("Rahul", 2, "EE");

        // making a List of
        // CSE Students.
        List<Student> cse_students = new ArrayList<>();
        cse_students.add(s1);
        cse_students.add(s2);

        // making a List of
        // EE Students
        List<Student> ee_students = new ArrayList<>();
        ee_students.add(s3);
        ee_students.add(s4);

        Department CSE = new Department("CSE", cse_students);
        Department EE = new Department("EE", ee_students);

        List<Department> departments = new ArrayList<>();
        departments.add(CSE);
        departments.add(EE);

        // creating an instance of Institute.
        Institute institute = new Institute("BITS", departments);

        System.out.print("Total students in institute: ");
        System.out.print(institute.getTotalStudentsInInstitute());
    }
}

package com.sda.advanced.ex6;

import java.util.List;
import java.util.Map;

public class DemoEx6 {

    public static void main(String[] args) {
        Company company = new Company();

        Employee employee1 = new Employee("Ion", "Popescu");
        Employee employee2 = new Employee("Vlad", "Ionescu");
        Employee employee3 = new Employee("Mihai", "Pop");

        Manager manager1 = new Manager("Vasile", "Lascar");
        Manager manager2 = new Manager("Dumitru", "Popescu");

        company.addEmployee(employee1, manager1);
        company.addEmployee(employee2, manager1);
        company.addEmployee(employee3, manager2);

        System.out.println(company.toString());

        company.removeEmployee(employee2);

        System.out.println(company.toString());
    }

    public static void printStringMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s : %s %n", entry.getKey(), entry.getValue());
        }
    }

    public static void printObjectMap(Map<Employee, Manager> map) {
        for (Map.Entry<Employee, Manager> entry : map.entrySet()) {
            System.out.printf("%s : %s %n", entry.getKey(), entry.getValue());
        }
    }

    public static void printMapOfList(Map<Manager, List<Employee>> map) {
        for (Map.Entry<Manager, List<Employee>> entry : map.entrySet()) {
            System.out.printf("%s : %n", entry.getKey());
            printList(entry.getValue());
        }
    }

    public static void printList(List<Employee> employees) {
        employees.forEach(employee -> System.out.println(employee + " "));
    }
}

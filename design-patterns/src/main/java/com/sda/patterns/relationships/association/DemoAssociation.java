package com.sda.patterns.relationships.association;

public class DemoAssociation {

    public static void main(String[] args) {
        Bank bank = new Bank("Axis");
        Employee emp = new Employee("Neha");

        System.out.println(emp.getEmployeeName() +
            " is employee of " + bank.getBankName());
    }
}

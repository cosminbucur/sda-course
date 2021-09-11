package com.sda.advanced.ex6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {

    private Map<Employee, Manager> employeeMap;
    private Map<Manager, List<Employee>> managerMap;

    public Company() {
        this.employeeMap = new HashMap<>();
        this.managerMap = new HashMap<>();
    }

    public Company(Map<Employee, Manager> employeeMap) {
        // TODO create employeeMap and managerMap from it
    }

    public void addEmployee(Employee employee, Manager manager) {
        // TODO Throw exception and catch it if employee or manager are null

        // add employee
        employeeMap.put(employee, manager);

        // add employee to manager
        if (managerMap.get(manager) != null) {
            managerMap.get(manager).add(employee);
        } else {
            List<Employee> employees = new ArrayList<>();
            employees.add(employee);
            managerMap.put(manager, employees);
        }
    }

    public void removeEmployee(Employee employee) {
        // TODO Throw exception and catch it if employee is null

        if (employeeMap.get(employee) != null) {
            // get manager for employee
            Manager manager = employeeMap.get(employee);
            List<Employee> employees = managerMap.get(manager);
            employees.remove(employee);
            managerMap.put(manager, employees);

            //remove from manager list
            employeeMap.remove(employee);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
            "employeeMap=" + employeeMap +
            ", managerMap=" + managerMap +
            '}';
    }
}

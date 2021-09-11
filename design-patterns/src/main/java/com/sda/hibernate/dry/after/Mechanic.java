package com.bucur.dry.after;

public class Mechanic {

    public void serviceCar() {
        System.out.println("servicing car now");
        performOtherTasks();
    }

    public void serviceBike() {
        System.out.println("servicing bike now");
        performOtherTasks();
    }

    public void performOtherTasks() {
        // do washing here
        // or do something else
        System.out.println("performing tasks other than servicing");
        // do whatever you want to do in the servicing package
    }
}

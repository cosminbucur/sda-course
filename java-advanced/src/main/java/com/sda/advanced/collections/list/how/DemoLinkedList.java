package com.sda.advanced.collections.list.how;

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {

    public static void main(String[] args) {
        // DONE: add 3 customers to a linked list
        List<Customer> customers = new LinkedList<>();

        Customer ana = new Customer("Ana");

        // DONE: CREATE
        customers.add(new Customer("Alex")); // 0
        customers.add(new Customer("Anto")); // 1
        customers.add(ana);                        // 2

        // DONE: READ
        customers.get(1);

        // DONE: UPDATE
        customers.set(0, new Customer("Paul"));

        // DONE: DELETE
        customers.remove(1);

        customers.remove(ana);

        System.out.println(customers.size());
    }
}

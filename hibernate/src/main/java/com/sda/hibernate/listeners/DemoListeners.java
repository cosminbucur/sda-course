package com.sda.hibernate.listeners;

import com.sda.hibernate.listeners.customer.Customer;
import com.sda.hibernate.listeners.customer.CustomerRepository;
import com.sda.hibernate.listeners.history.CustomerHistory;
import com.sda.hibernate.listeners.history.CustomerHistoryRepository;

import java.util.List;

public class DemoListeners {

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerHistoryRepository customerHistoryRepository = new CustomerHistoryRepository();

        Customer customer = new Customer("jon", "snow");

        customerRepository.create(customer);

        Customer newCustomer = customerRepository.findById(1L);
        newCustomer.setFirstName("alex");
        newCustomer.setLastName("vasile");

        customerRepository.update(newCustomer);

        Customer updatedCustomer = customerRepository.findById(1L);
        customerRepository.delete(updatedCustomer);

        List<CustomerHistory> history = customerHistoryRepository.findAll();
        System.out.println(history);
    }
}

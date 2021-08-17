package com.company.service;

import com.company.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public Customer registerCustomer(String name, String lastName, String dateOfBirth, String phoneNumber) {

        Customer customer = new Customer(name, lastName, dateOfBirth, phoneNumber);
        customers.add(customer);

        return customer;
    }

    public List<Customer> getCustomers() {

        return new ArrayList<>(customers);
    }
}

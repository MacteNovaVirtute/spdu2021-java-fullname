package com.company.domain;

public class Customer {

    private final String name;
    private final String lastName;
    private final String dateOfBirth;
    private final String phoneNumber;

    public Customer(String name, String lastName,  String dateOfBirth, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

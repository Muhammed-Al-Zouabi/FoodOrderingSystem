package com.arel.oop;

public class Customer extends User {
    private String address;

    public Customer(String name, String phone, String address) {
        super(name, phone); // Calls User constructor
        this.address = address;
    }

    public String getAddress() { return address; }
}
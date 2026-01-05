package com.arel.oop;

public class Customer extends User {
    private String address;
    private String phone;

    public Customer(String id, String name, String email, String address, String phone) {
        super(id, name, email); // This fixes the inheritance link to User
        this.address = address;
        this.phone = phone;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}
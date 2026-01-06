package com.arel.oop;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double totalAmount;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        calculateTotal();
        System.out.println(item.getName() + " added.");
    }

    public void calculateTotal() {
        totalAmount = 0.0;
        for(MenuItem item : items) {
            totalAmount += item.getPrice();
        }
    }

    public void processPayment(PaymentMethod method) {
        if(method.processPayment()) {
            System.out.println("Order Paid! Receipt for: " + customer.getName());
        } else {
            System.out.println("Payment Failed.");
        }
    }

    public double getTotalAmount() { return totalAmount; }
}
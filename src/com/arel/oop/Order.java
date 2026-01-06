package com.arel.oop;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double totalAmount;

    // Create a new order for a specific customer
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    // Add a menu item to the order and update total price
    public void addItem(MenuItem item) {
        items.add(item);
        calculateTotal();
        System.out.println(item.getName() + " added.");
    }

    // Recalculate the total price of the order
    public void calculateTotal() {
        totalAmount = 0.0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice();
        }
    }

    // Process payment using the selected payment method
    public void processPayment(PaymentMethod method) {
        if (method.processPayment()) {
        	System.out.println("Order Paid! Order #" + orderId + " Receipt for: " + customer.getName());
        } else {
            System.out.println("Payment Failed.");
        }
    }

    // Return total amount of the order
    public double getTotalAmount() {
        return totalAmount;
    }
}

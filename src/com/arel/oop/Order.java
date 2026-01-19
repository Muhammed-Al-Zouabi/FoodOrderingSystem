package com.arel.oop;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

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
        if (item != null) {
            items.add(item);
            calculateTotal();
            System.out.println(item.getName() + " added.");
        }
    }

    public void calculateTotal() {
        totalAmount = 0.0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice();
        }
    }

    public void displayReceipt() {
        System.out.println("\n============================");
        System.out.println("      THUNDER RECEIPT       ");
        System.out.println("============================");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Phone: " + customer.getPhoneNumber());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("----------------------------");
        for (MenuItem item : items) {
            System.out.println(item.getName() + ": " + item.getPrice() + " TL");
        }
        System.out.println("----------------------------");
        System.out.println("TOTAL: " + totalAmount + " TL");
        System.out.println("============================\n");
    }

    public void saveToCSV() {
        try (FileWriter writer = new FileWriter("receipt_" + orderId + ".csv")) {
            writer.append("OrderID,Customer,Phone,Items,Total\n");
            StringBuilder foodNames = new StringBuilder();
            for (MenuItem item : items) {
                foodNames.append(item.getName()).append(" | ");
            }
            writer.append(orderId + "," + customer.getName() + "," + customer.getPhoneNumber() + "," + foodNames.toString() + "," + totalAmount + " TL\n");
            System.out.println("System: CSV record created.");
        } catch (IOException e) {
            System.out.println("Error: Close the CSV file in Eclipse!");
        }
    }

    public void processPayment(PaymentMethod method) {
        if (method.processPayment()) {
            System.out.println("Payment success.");
            saveToCSV();
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
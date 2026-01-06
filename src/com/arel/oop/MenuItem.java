package com.arel.oop;

// Represents a single item in a restaurant menu
public class MenuItem implements Orderable {

    private String name;
    private double price;
    private String category;

    // Create a menu item with name, price and category
    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Called when the item is added to an order
    @Override
    public void addToOrder() {
        System.out.println(name + " added to order.");
    }

    // Return item price
    @Override
    public double getPrice() {
        return price;
    }

    // Return item name
    public String getName() {
        return name;
    }

    // Display item information
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

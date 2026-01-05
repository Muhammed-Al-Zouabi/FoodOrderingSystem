package com.arel.oop;

/**
 * MenuItem represents a specific food or drink.
 * It implements the Orderable interface.
 */
public class MenuItem implements Orderable {
    
    private String name;
    private double price;
    private String description;
    private String category; // e.g., "Main Course", "Drink"

    public MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    // These methods come from the Orderable interface
    @Override
    public double getPrice() { return price; }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    public String getCategory() { return category; }
    
    @Override
    public String toString() {
        return name + " ($" + price + ") - " + description;
    }
}
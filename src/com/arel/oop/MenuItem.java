package com.arel.oop;

public class MenuItem implements Orderable {
    private String name;
    private double price;
    private String category;

    public MenuItem(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public void addToOrder() {
        System.out.println(name + " added to order.");
    }

    @Override
    public double getPrice() { return price; }
    public String getName() { return name; }
    
    @Override
    public String toString() { return name + " ($" + price + ")"; }
}
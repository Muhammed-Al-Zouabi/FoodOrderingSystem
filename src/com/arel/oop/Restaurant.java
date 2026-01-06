package com.arel.oop;

import java.util.ArrayList;
import java.util.List;

// Represents a restaurant and its menu
public class Restaurant {

    private String name;
    private List<MenuItem> menu;

    // Create a restaurant with an empty menu
    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Add a new item to the restaurant menu
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Display all menu items of the restaurant
    public void displayMenu() {
        System.out.println("--- MENU FOR " + name + " ---");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }

    // Get a menu item by index
    public MenuItem getItem(int index) {
        if (index >= 0 && index < menu.size()) {
            return menu.get(index);
        }
        return null;
    }
}

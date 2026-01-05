// Represents a restaurant in the delivery system
package com.arel.oop;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Orderable> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    // Method to add food to the menu
    public void addToMenu(Orderable item) {
        menu.add(item);
    }

    // Method to show the menu to the customer
    public void displayMenu() {
        System.out.println("\n=== " + name.toUpperCase() + " MENU ===");
        for (int i = 0; i < menu.size(); i++) {
            Orderable item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " TL");
        }
    }

    // Method to pick an item from the list
    public Orderable getItem(int index) {
        if (index >= 0 && index < menu.size()) {
            return menu.get(index);
        }
        return null;
    }
}
package com.arel.oop;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("\n--- MENU FOR " + name + " ---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i).getName() + " ($" + menu.get(i).getPrice() + ")");
        }
    }

    public MenuItem getItem(int index) {
        if (index >= 0 && index < menu.size()) {
            return menu.get(index);
        }
        System.out.println("Invalid selection.");
        return null;
    }

    public String getName() {
        return name;
    }
}
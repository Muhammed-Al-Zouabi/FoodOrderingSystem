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
        System.out.println("--- MENU FOR " + name + " ---");
        for (MenuItem item : menu) {
            System.out.println(item.toString());
        }
    }

    public MenuItem getItem(int index) {
        if(index >= 0 && index < menu.size()) return menu.get(index);
        return null;
    }
}
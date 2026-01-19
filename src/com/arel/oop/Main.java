package com.arel.oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Restaurant r1 = new Restaurant("Hey Doner");
        r1.addMenuItem(new MenuItem("Chicken Zurna Durum", 110.0, "Main"));
        r1.addMenuItem(new MenuItem("Meat Doner Portion", 220.0, "Main"));
        r1.addMenuItem(new MenuItem("Ayran", 25.0, "Drink"));
        r1.addMenuItem(new MenuItem("Coca Cola", 40.0, "Drink"));

        Restaurant r2 = new Restaurant("Pidem");
        r2.addMenuItem(new MenuItem("Kiymali Pide", 140.0, "Main"));
        r2.addMenuItem(new MenuItem("Kasarli Pide", 130.0, "Main"));
        r2.addMenuItem(new MenuItem("Water", 10.0, "Drink"));
        r2.addMenuItem(new MenuItem("Kunefe", 95.0, "Dessert"));

        System.out.println("=== THUNDER DELIVERY SYSTEM ===");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Customer Login");
            System.out.println("2. Restaurant Manager");
            System.out.println("0. Exit System");
            System.out.print("Selection: ");
            int role = sc.nextInt();
            sc.nextLine(); 

            if (role == 1) {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Delivery Address: ");
                String address = sc.nextLine();
                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();

                Customer user = new Customer(name, phone, address);
                Order order = new Order(2026, user);

                boolean browsing = true;
                while (browsing) {
                    System.out.println("\n--- Welcome " + user.getName() + " ---");
                    System.out.println("1. Select Restaurant & Add Food");
                    System.out.println("2. View Cart & Checkout");
                    System.out.println("0. Log Out");
                    System.out.print("Action: ");
                    int action = sc.nextInt();
                    sc.nextLine(); 

                    if (action == 1) {
                        System.out.println("\nAvailable Restaurants:");
                        System.out.println("1. " + r1.getName());
                        System.out.println("2. " + r2.getName());
                        System.out.print("Choice: ");
                        int resChoice = sc.nextInt();
                        sc.nextLine(); 
                        
                        Restaurant selected = (resChoice == 1) ? r1 : r2;
                        
                        boolean addingItems = true;
                        while (addingItems) {
                            selected.displayMenu();
                            System.out.print("Enter item number (or 0 to finish): ");
                            int choice = sc.nextInt();
                            sc.nextLine(); 
                            
                            if (choice == 0) {
                                addingItems = false;
                            } else {
                                MenuItem item = selected.getItem(choice - 1);
                                if (item != null) {
                                    order.addItem(item);
                                    System.out.println("Total so far: " + order.getTotalAmount() + " TL");
                                }
                            }
                        }
                    } else if (action == 2) {
                        if (order.getTotalAmount() > 0) {
                            order.displayReceipt(); 
                            System.out.println("Payment: 1. Card 2. Cash");
                            System.out.print("Choice: ");
                            int payChoice = sc.nextInt();
                            sc.nextLine(); 
                            
                            PaymentMethod pm = (payChoice == 1) ? 
                                new CreditCardPayment(order.getTotalAmount(), "4444555566667777", "05/29") :
                                new CashPayment(order.getTotalAmount());
                            order.processPayment(pm);
                            browsing = false; 
                        }
                    } else if (action == 0) {
                        browsing = false;
                    }
                }
            } else if (role == 2) {
                boolean managerRunning = true;
                while (managerRunning) {
                    System.out.println("\n--- Restaurant Manager Menu ---");
                    System.out.println("1. Add Item to Hey Doner");
                    System.out.println("2. Add Item to Pidem");
                    System.out.println("0. Back to Main Menu");
                    System.out.print("Action: ");
                    int mgrAction = sc.nextInt();
                    sc.nextLine();

                    if (mgrAction == 1 || mgrAction == 2) {
                        Restaurant selected = (mgrAction == 1) ? r1 : r2;
                        System.out.print("Enter New Item Name: ");
                        String newItemName = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Category (Main/Drink/Dessert): ");
                        String category = sc.nextLine();

                        selected.addMenuItem(new MenuItem(newItemName, price, category));
                        System.out.println("Item successfully added to " + selected.getName() + "!");
                    } else if (mgrAction == 0) {
                        managerRunning = false;
                    }
                }
            } else if (role == 0) {
                running = false;
            }
        }
        sc.close();
    }
}
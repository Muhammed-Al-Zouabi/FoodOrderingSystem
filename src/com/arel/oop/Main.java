package com.arel.oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== WELCOME TO THUNDER DELIVERY SYSTEM ===");

        // Create restaurants and add some sample menu items
        Restaurant r1 = new Restaurant("Hey Doner");
        r1.addMenuItem(new MenuItem("Chicken Zurna Durum", 110.00, "Main"));
        r1.addMenuItem(new MenuItem("Meat Doner Portion", 220.00, "Main"));
        r1.addMenuItem(new MenuItem("Ayran", 25.00, "Drink"));

        Restaurant r2 = new Restaurant("Pidem");
        r2.addMenuItem(new MenuItem("Kiymali Pide", 140.00, "Main"));
        r2.addMenuItem(new MenuItem("Kasarli Pide", 130.00, "Main"));
        r2.addMenuItem(new MenuItem("Kusbasili Pide", 170.00, "Main"));

        Restaurant r3 = new Restaurant("Little Caesars");
        r3.addMenuItem(new MenuItem("Pepperoni Pizza", 160.00, "Pizza"));
        r3.addMenuItem(new MenuItem("Sebzeli Pizza", 150.00, "Pizza"));
        r3.addMenuItem(new MenuItem("Coca Cola Zero", 40.00, "Drink"));

        // Create a sample customer for the demo
        Customer customer = new Customer(
                "Muhammed Al Zouabi",
                "555-0000",
                "Istanbul"
        );

        System.out.println("\nUser Logged In: " + customer.getName());

        // Display available restaurants
        System.out.println("\nAvailable Restaurants:");
        System.out.println("1. Hey Doner");
        System.out.println("2. Pidem");
        System.out.println("3. Little Caesars");

        // For this demo, select one restaurant and show its menu
        System.out.println("\nSelected Restaurant: Pidem");
        r2.displayMenu();

        // Create an order for the customer
        Order myOrder = new Order(77, customer);

        // Add items to the order
        System.out.println("\nAdding items to order...");
        myOrder.addItem(r2.getItem(0)); // Kiymali Pide
        myOrder.addItem(r2.getItem(1)); // Kasarli Pide

        // Show total price
        System.out.println("\nOrder Total: $" + myOrder.getTotalAmount());

        // Process payment using credit card
        System.out.println("\nProcessing credit card payment...");
        PaymentMethod cardPayment = new CreditCardPayment(
                myOrder.getTotalAmount(),
                "5555444433332222",
                "12/28"
        );
        myOrder.processPayment(cardPayment);

        // Process payment using cash to demonstrate polymorphism
        System.out.println("\nProcessing cash payment...");
        PaymentMethod cashPayment = new CashPayment(myOrder.getTotalAmount());
        myOrder.processPayment(cashPayment);

        System.out.println("\n=== DEMO FINISHED ===");
    }
}


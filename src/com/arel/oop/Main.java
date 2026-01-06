package com.arel.oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== WELCOME TO THUNDER DELIVERY SYSTEM ===");

        // Create restaurants and add menu items
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

        // Create sample customer
        Customer customer = new Customer(
                "Muhammed Al Zouabi",
                "555-0000",
                "Istanbul"
        );

        System.out.println("\nUser Logged In: " + customer.getName());

        // Show available restaurants
        System.out.println("\nAvailable Restaurants:");
        System.out.println("1. Hey Doner");
        System.out.println("2. Pidem");
        System.out.println("3. Little Caesars");

        // Demo selection: Pidem
        System.out.println("\nSelected Restaurant: Pidem");
        r2.displayMenu();

        // Create order
        Order myOrder = new Order(77, customer);

        // Add items to cart
        System.out.println("\n>> Adding items to cart...");
        myOrder.addItem(r2.getItem(0)); // Kiymali Pide
        myOrder.addItem(r2.getItem(1)); // Kasarli Pide

        // Show order total
        System.out.println("\nOrder Total: $" + myOrder.getTotalAmount());

        // Credit card payment
        System.out.println("\nProcessing credit card payment...");
        PaymentMethod cardPayment = new CreditCardPayment(
                myOrder.getTotalAmount(),
                "5555444433332222",
                "12/28"
        );
        myOrder.processPayment(cardPayment);

        // Cash payment (extra test to show polymorphism)
        System.out.println("\n(Extra test) Trying another payment method to show polymorphism...");
        System.out.println("\nProcessing cash payment...");
        PaymentMethod cashPayment = new CashPayment(myOrder.getTotalAmount());
        myOrder.processPayment(cashPayment);

        System.out.println("\n=== DEMO FINISHED ===");
    }
}

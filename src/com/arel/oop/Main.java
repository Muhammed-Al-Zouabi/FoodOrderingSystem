package com.arel.oop;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== WELCOME TO THUNDER DELIVERY SYSTEM ===");
        System.out.println(">> THUNDER: Your food, delivered as quick as lightning! ⚡");

        // ---------------- RESTAURANTS ----------------

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

        // ---------------- CUSTOMER LOGIN ----------------

        Customer customer = new Customer(
                "Muhammed Al Zouabi",
                "555-0000",
                "Istanbul, Arel University"
        );

        System.out.println("\nUser Logged In: " + customer.getName());

        // ---------------- BROWSE RESTAURANTS ----------------

        System.out.println("\n>> BROWSING RESTAURANTS ON THUNDER APP...");
        System.out.println("1. Hey Doner");
        System.out.println("2. Pidem");
        System.out.println("3. Little Caesars");

        // ---------------- SELECT RESTAURANT ----------------

        System.out.println("\n>> User selected: Pidem");
        r2.displayMenu();

        // ---------------- CREATE ORDER ----------------

        Order myOrder = new Order(77, customer);

        System.out.println("\n>> Adding items to cart...");
        myOrder.addItem(r2.getItem(0)); // Kiymali Pide
        myOrder.addItem(r2.getItem(1)); // Kasarli Pide

        System.out.println("\n>> Order Total: $" + myOrder.getTotalAmount());

        // ---------------- CREDIT CARD PAYMENT ----------------

        System.out.println("\n>> Processing Credit Card Payment...");
        PaymentMethod myCard = new CreditCardPayment(
                myOrder.getTotalAmount(),
                "5555444433332222",
                "12/28"
        );
        myOrder.processPayment(myCard);

        // ---------------- CASH PAYMENT (POLYMORPHISM) ----------------

        System.out.println("\n>> Testing Cash Payment Flow...");
        PaymentMethod myCash = new CashPayment(myOrder.getTotalAmount());
        myOrder.processPayment(myCash);

        System.out.println("\n=== DEMO FINISHED ===");
    }
}

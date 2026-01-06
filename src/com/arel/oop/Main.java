package com.arel.oop;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== WELCOME TO THUNDER DELIVERY SYSTEM ===");
        System.out.println(">> THUNDER: Your food, delivered as quick as lightning! ⚡");

        // --- STEP 1: CREATE THE "THUNDER" NETWORK (Restaurants) ---

        // Restaurant 1: Hey Doner
        Restaurant r1 = new Restaurant("Hey Doner");
        // FIX: We use 'addMenuItem' because that is what we named it in Restaurant.java
        r1.addMenuItem(new MenuItem("Chicken Zurna Durum", 110.00, "Main"));
        r1.addMenuItem(new MenuItem("Meat Doner Portion", 220.00, "Main"));
        r1.addMenuItem(new MenuItem("Ayran", 25.00, "Drink"));

        // Restaurant 2: Pidem
        Restaurant r2 = new Restaurant("Pidem");
        r2.addMenuItem(new MenuItem("Kiymali Pide", 140.00, "Main"));
        r2.addMenuItem(new MenuItem("Kasarli Pide", 130.00, "Main"));
        r2.addMenuItem(new MenuItem("Kusbasili Pide", 170.00, "Main"));

        // Restaurant 3: Little Caesars
        Restaurant r3 = new Restaurant("Little Caesars");
        r3.addMenuItem(new MenuItem("Pepperoni Pizza", 160.00, "Pizza"));
        r3.addMenuItem(new MenuItem("Sebzeli Pizza", 150.00, "Pizza"));
        r3.addMenuItem(new MenuItem("Coca Cola Zero", 40.00, "Drink"));

        // --- STEP 2: SIMULATE USER LOGIN ---
        // Customer constructor: Name, Phone, Address
        Customer customer = new Customer("Muhammed Al Zouabi", "555-0000", "Istanbul, Arel Univ");
        System.out.println("\nUser Logged In: " + customer.getName());

        System.out.println("\n>> BROWSING RESTAURANTS ON THUNDER APP...");
        System.out.println("1. Hey Doner");
        System.out.println("2. Pidem");
        System.out.println("3. Little Caesars");

        // --- STEP 3: USER SELECTS "PIDEM" ---
        System.out.println("\n>> User selected: Pidem");
        r2.displayMenu(); // Show Pidem menu

        // --- STEP 4: ORDERING ---
        // Order constructor: ID (int) and Customer
        Order myOrder = new Order(77, customer);

        System.out.println("\n>> Adding items to cart...");
        myOrder.addItem(r2.getItem(0)); // Kiymali Pide
        myOrder.addItem(r2.getItem(1)); // Kasarli Pide

        // --- STEP 5: CHECKOUT ---
        System.out.println("\n>> Proceeding to Checkout...");
        // Payment needs: Amount, CardNum, Expiry
        PaymentMethod myCard = new CreditCardPayment(myOrder.getTotalAmount(), "5555444433332222", "12/28");
        
        // FIX: We use 'processPayment' because that is what we named it in Order.java
        myOrder.processPayment(myCard);
        
        System.out.println("=== DEMO FINISHED ===");
    }
}
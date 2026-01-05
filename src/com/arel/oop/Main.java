// Main entry point for the delivery application
package com.arel.oop;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== WELCOME TO THUNDER DELIVERY SYSTEM ===");
        System.out.println(">> THUNDER: Your food, delivered as quick as lightning! ⚡");

        // --- STEP 1: CREATE THE "THUNDER" NETWORK (Restaurants) ---
        
        // Restaurant 1: Hey Doner (Local Favorite)
        Restaurant r1 = new Restaurant("Hey Doner");
        r1.addToMenu(new MenuItem("Chicken Zurna Durum", 110.00, "Large chicken wrap", "Main"));
        r1.addToMenu(new MenuItem("Meat Doner Portion", 220.00, "120g meat", "Main"));
        r1.addToMenu(new MenuItem("Ayran", 25.00, "Fresh Yogurt", "Drink"));

        // Restaurant 2: Pidem (The Pide Specialist)
        Restaurant r2 = new Restaurant("Pidem");
        r2.addToMenu(new MenuItem("Kiymali Pide", 140.00, "Minced meat pide", "Main"));
        r2.addToMenu(new MenuItem("Kasarli Pide", 130.00, "Cheese pide", "Main"));
        r2.addToMenu(new MenuItem("Kusbasili Pide", 170.00, "Diced meat pide", "Main"));

        // Restaurant 3: Little Caesars (Pizza)
        Restaurant r3 = new Restaurant("Little Caesars");
        r3.addToMenu(new MenuItem("Pepperoni Pizza", 160.00, "Medium size", "Pizza"));
        r3.addToMenu(new MenuItem("Sebzeli Pizza", 150.00, "Veggie pizza", "Pizza"));
        r3.addToMenu(new MenuItem("Coca Cola Zero", 40.00, "Can", "Drink"));

        // --- STEP 2: SIMULATE USER LOGIN ---
        Customer customer = new Customer("U-99", "Muhammed Al Zouabi", "muhammed@arel.edu", "Istanbul", "555-0000");
        System.out.println("\nUser Logged In: " + customer.getName());
        
        System.out.println("\n>> BROWSING RESTAURANTS ON THUNDER APP...");
        System.out.println("1. Hey Doner");
        System.out.println("2. Pidem");
        System.out.println("3. Little Caesars");

        // --- STEP 3: USER SELECTS "PIDEM" ---
        System.out.println("\n>> User selected: Pidem");
        r2.displayMenu(); // Show Pidem menu

        // --- STEP 4: ORDERING ---
        Order myOrder = new Order("ORD-THUNDER-77", customer);
        
        System.out.println("\n>> Adding items to cart...");
        myOrder.addItem(r2.getItem(0)); // Kiymali Pide
        myOrder.addItem(r2.getItem(1)); // Kasarli Pide
        
        // --- STEP 5: CHECKOUT ---
        System.out.println("\n>> Proceeding to Checkout...");
        PaymentMethod myCard = new CreditCardPayment("5555-4444-3333-2222", "999");
        myOrder.placeOrder(myCard);
    }
}
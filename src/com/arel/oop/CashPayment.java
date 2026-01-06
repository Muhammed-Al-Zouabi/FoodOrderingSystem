package com.arel.oop;

// Payment method for cash payments
public class CashPayment extends PaymentMethod {

    // Create a cash payment with the given amount
    public CashPayment(double amount) {
        super(amount);
    }

    // Simulate cash payment process
    @Override
    public boolean processPayment() {
        System.out.println("Processing cash payment of $" + amount);
        System.out.println("Payment complete.");
        return true;
    }
}

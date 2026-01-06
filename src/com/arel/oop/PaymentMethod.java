package com.arel.oop;

// Base class for all payment types
public abstract class PaymentMethod {

    protected double amount;

    // Store payment amount
    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    // Each payment type must implement its own logic
    public abstract boolean processPayment();
}

package com.arel.oop;

public class CashPayment extends PaymentMethod {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing Cash Payment of $" + amount);
        System.out.println("Payment Complete.");
        return true;
    }
}

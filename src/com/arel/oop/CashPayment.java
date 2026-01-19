package com.arel.oop;
public class CashPayment extends PaymentMethod {
   public CashPayment(double amount) {
        super(amount);
    }
    @Override
    public boolean processPayment() {
        System.out.println("Processing cash payment of $" + amount);
        System.out.println("Payment complete.");
        return true;
    }
}

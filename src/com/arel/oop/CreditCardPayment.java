package com.arel.oop;

public class CreditCardPayment extends PaymentMethod {
    private String cardNumber;
    private String expiry;

    public CreditCardPayment(double amount, String cardNumber, String expiry) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expiry = expiry;
    }

    @Override
    public boolean processPayment() {
        if(cardNumber.length() == 16) {
            System.out.println("Paying $" + amount + " with Card ending in " + cardNumber.substring(12));
            return true;
        }
        return false;
    }
}
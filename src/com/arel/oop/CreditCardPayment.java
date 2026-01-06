package com.arel.oop;

// Payment method using credit card
public class CreditCardPayment extends PaymentMethod {

    private String cardNumber;
    private String expiry;

    // Create a credit card payment with card details
    public CreditCardPayment(double amount, String cardNumber, String expiry) {
        super(amount);
        this.cardNumber = cardNumber;
        this.expiry = expiry;
    }

    // Simple validation and payment simulation
    @Override
    public boolean processPayment() {
        if (cardNumber.length() == 16) {
        	System.out.println("Paying $" + amount + " with Card ending in " + cardNumber.substring(12));
        	System.out.println("Expiry date: " + expiry);
        	return true;
        }
        return false;
    }
}

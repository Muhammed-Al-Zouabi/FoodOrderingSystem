package com.arel.oop;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("\nProcessing Payment...");
        // Simulates verifying the card
        System.out.println("Card Used: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Payment of " + amount + " TL Successful.");
    }
    public String getCvv() { return cvv; }
}
package com.arel.oop;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String orderId;
	private Customer customer;
	private List<Orderable> items;
	private double totalPrice;

	public Order(String orderId, Customer customer) {
		this.orderId = orderId;
		this.customer = customer;
		this.items = new ArrayList<>();
		this.totalPrice = 0.0;
	}

	public void addItem(Orderable item) {
		if (item != null) {
			items.add(item);
			totalPrice += item.getPrice();
			System.out.println(item.getName() + " added to basket.");
		}
	}

	// UPDATED: This now asks for a PaymentMethod to finish the order
	public void placeOrder(PaymentMethod paymentMethod) {
		if (items.isEmpty()) {
			System.out.println("Basket is empty.");
			return;
		}

		System.out.println("\n--- ORDER SUMMARY ---");
		System.out.println("Customer: " + customer.getName());
		System.out.println("Total Amount: " + totalPrice + " TL");

		// Polymorphism: The payment method handles the logic!
		paymentMethod.pay(totalPrice);
		System.out.println("Order " + orderId + " has been sent to the kitchen!");
	}

	// Getter for totalPrice (useful for testing later)
	public double getTotalPrice() {
		return totalPrice;
	}
}
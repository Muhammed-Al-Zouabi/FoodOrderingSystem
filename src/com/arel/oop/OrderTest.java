package com.arel.oop;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class OrderTest {
    @Test
    public void testAddItem() {
        Customer customer = new Customer("Test User", "555-1111", "Istanbul");
        Order order = new Order(1, customer);

        order.addItem(new MenuItem("Burger", 50.0, "Main"));
        order.addItem(new MenuItem("Cola", 10.0, "Drink"));

        assertEquals(60.0, order.getTotalAmount(), 0.001);
    }

    @Test
    public void testGetTotalAmount() {
        Customer customer = new Customer("Test User", "555-2222", "Istanbul");
        Order order = new Order(2, customer);

        order.addItem(new MenuItem("Pizza", 120.0, "Main"));

        assertEquals(120.0, order.getTotalAmount(), 0.001);
    }

    @Test
    public void testProcessPayment() {
        Customer customer = new Customer("Test User", "555-3333", "Istanbul");
        Order order = new Order(3, customer);

        order.addItem(new MenuItem("Sandwich", 30.0, "Main"));
        PrintStream oldOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        PaymentMethod successPayment = new PaymentMethod(order.getTotalAmount()) {
            @Override
            public boolean processPayment() {
                return true;
            }
        };
        order.processPayment(successPayment);
        PaymentMethod failPayment = new PaymentMethod(order.getTotalAmount()) {
            @Override
            public boolean processPayment() {
                return false;
            }
        };
        order.processPayment(failPayment);
        System.setOut(oldOut);

        String output = outContent.toString();
        assertTrue(output.contains("Order Paid!"));
        assertTrue(output.contains("Payment Failed."));
    }
}

package com.arel.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class ThunderTest {

    @Test
    public void testOrderCalculation() {
        Customer c = new Customer("Test User", "123", "Address");
        Order o = new Order(1, c);

        MenuItem m1 = new MenuItem("Pide", 100.0, "Food");
        MenuItem m2 = new MenuItem("Coke", 25.0, "Drink");

        o.addItem(m1);
        o.addItem(m2);

        assertEquals(125.0, o.getTotalAmount(), 0.01);
    }

    @Test
    public void testEmptyOrderTotal() {
        Customer c = new Customer("Test User", "123", "Address");
        Order o = new Order(2, c);

        assertEquals(0.0, o.getTotalAmount(), 0.01);
    }
}


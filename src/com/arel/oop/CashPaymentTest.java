package com.arel.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class CashPaymentTest {

    @Test
    public void testCashPaymentAlwaysSucceeds() {
        CashPayment payment = new CashPayment(100.0);

        boolean result = payment.processPayment();

        assertTrue(result);
    }

    @Test
    public void testCashPaymentAmount() {
        CashPayment payment = new CashPayment(75.0);

        assertEquals(75.0, payment.amount, 0.001);
    }
}

package com.arel.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuItemTest {

    @Test
    public void testGetPrice() {
        MenuItem item = new MenuItem("Burger", 50.0, "Main");
        assertEquals(50.0, item.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        MenuItem item = new MenuItem("Burger", 50.0, "Main");
        assertEquals("Burger", item.getName());
    }
}

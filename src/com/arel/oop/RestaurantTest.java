package com.arel.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class RestaurantTest {

    @Test
    public void testGetItemValidIndex() {
        Restaurant restaurant = new Restaurant("Test Restaurant");
        restaurant.addMenuItem(new MenuItem("Burger", 50.0, "Main"));

        MenuItem item = restaurant.getItem(0);

        assertNotNull(item);
        assertEquals("Burger", item.getName());
    }

    @Test
    public void testGetItemInvalidIndex() {
        Restaurant restaurant = new Restaurant("Test Restaurant");
        restaurant.addMenuItem(new MenuItem("Burger", 50.0, "Main"));

        assertNull(restaurant.getItem(-1));
        assertNull(restaurant.getItem(10));
    }
}

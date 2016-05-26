package com.company.kata.k09checkout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/25/2016
*/
public class PriceListTest {

    PriceList priceList;

    @Before
    public void setUp() throws Exception {
        priceList = new PriceList();
    }

    @Test
    public void testAddItemWithSpecialPrice() {
        priceList.addItem("A", 50, 3, 130);
        assertEquals(1, priceList.getSize());
        assertEquals(true, priceList.isItemPresent("A"));
        assertEquals(50, priceList.getItemPrice("A"));
        assertEquals(true, priceList.isItemHasSpecialPrice("A"));
        assertEquals(3, priceList.getItemSpecialCount("A"));
        assertEquals(130, priceList.getItemSpecialPrice("A"));
    }

    @Test
    public void testAddItemWithoutSpecialPrice() {
        priceList.addItem("C", 20);
        assertEquals(1, priceList.getSize());
        assertEquals(true, priceList.isItemPresent("C"));
        assertEquals(20, priceList.getItemPrice("C"));
        assertEquals(false, priceList.isItemHasSpecialPrice("C"));
        assertEquals(0, priceList.getItemSpecialCount("C"));
        assertEquals(0, priceList.getItemSpecialPrice("C"));
    }
}
package com.company.kata.k09checkout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/25/2016
*/
public class CheckOutTest {

    CheckOut co;
    PriceList priceList;

    @Before
    public void setUp() {
        priceList = new PriceList();
        priceList.addItem("A", 50, 3, 130);
        priceList.addItem("B", 30, 2, 45);
        priceList.addItem("C", 20);
        priceList.addItem("D", 15);
    }

    @Test
    public void testTotals() {
        assertEquals(  0, price(""));
        assertEquals( 50, price("A"));
        assertEquals( 80, price("AB"));
        assertEquals(115, price("CDBA"));

        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));

        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }

    @Test
    public void testIncremental() {
        co = new CheckOut(priceList);
        assertEquals(  0, co.getTotal());
        co.scan("A");
        assertEquals( 50, co.getTotal());
        co.scan("B");
        assertEquals( 80, co.getTotal());
        co.scan("A");
        assertEquals(130, co.getTotal());
        co.scan("A");
        assertEquals(160, co.getTotal());
        co.scan("B");
        assertEquals(175, co.getTotal());
     }

    public int price(String goods) {
        co = new CheckOut(priceList);
        for (int i = 0; i < goods.length(); i++) {
            co.scan(String.valueOf(goods.charAt(i)));
        }
        return co.getTotal();
    }
}
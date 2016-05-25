package com.company.j8inaction.apples;

import org.junit.Test;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/24/2016
*/
public class WeightAppleFormatterTest {

    @Test
    public void testHeavyApple() throws Exception {
        Apple apple = new Apple("Green", 151);
        AppleFormatter formatter = new WeightAppleFormatter();
        String expected = "151";
        assertEquals(expected, formatter.accept(apple));
    }

    @Test
    public void testLightApple() throws Exception {
        Apple apple = new Apple("Red", 150);
        AppleFormatter formatter = new WeightAppleFormatter();
        String expected = "150";
        assertEquals(expected, formatter.accept(apple));
    }
}
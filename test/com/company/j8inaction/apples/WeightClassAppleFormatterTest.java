package com.company.j8inaction.apples;

import org.junit.Test;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/24/2016
*/
public class WeightClassAppleFormatterTest {

    @Test
    public void testHeavyApple() throws Exception {
        Apple apple = new Apple("Green", 151);
        AppleFormatter formatter = new WeightClassAppleFormatter();
        String expected = "Green 151g => Heavy";
        assertEquals(expected, formatter.accept(apple));
    }

    @Test
    public void testLightApple() throws Exception {
        Apple apple = new Apple("Red", 150);
        AppleFormatter formatter = new WeightClassAppleFormatter();
        String expected = "Red 150g => Light";
        assertEquals(expected, formatter.accept(apple));
    }
}
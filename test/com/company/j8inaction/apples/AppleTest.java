package com.company.j8inaction.apples;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/24/2016
*/
public class AppleTest {

    Apple apple;

    @Before
    public void setUp() {
        apple = new Apple("Red", 151);
    }

    @Test
    public void testGetColor() throws Exception {
        assertEquals("Red", apple.getColor());
    }

    @Test
    public void testSetColor() throws Exception {
        apple.setColor("Green");
        assertEquals("Green", apple.getColor());
    }

    @Test
    public void testGetWeight() throws Exception {
        assertEquals(151, apple.getWeight());
    }

    @Test
    public void testSetWeight() throws Exception {
        apple.setWeight(100);
        assertEquals(100, apple.getWeight());
    }
}
package com.company.kata.k11sortingout;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/26/2016
*/
public class RackTest {

    Rack rack;

    @Before
    public void setUp() throws Exception {
        rack = new Rack();

    }

    @Test
    public void testAddBall() throws Exception {
        assertEquals(Collections.emptyList(), rack.getBalls());
        rack.addBall(20);
        assertEquals(Collections.singletonList(20), rack.getBalls());
        rack.addBall(10);
        assertEquals(Arrays.asList(10, 20), rack.getBalls());
        rack.addBall(30);
        assertEquals(Arrays.asList(10, 20, 30), rack.getBalls());
        rack.addBall(25);
        assertEquals(Arrays.asList(10, 20, 25, 30), rack.getBalls());
        rack.addBall(5);
        assertEquals(Arrays.asList(5, 10, 20, 25, 30), rack.getBalls());
        rack.addBall(5);
        assertEquals(Arrays.asList(5, 5, 10, 20, 25, 30), rack.getBalls());
        rack.addBall(30);
        assertEquals(Arrays.asList(5, 5, 10, 20, 25, 30, 30), rack.getBalls());
        rack.addBall(20);
        assertEquals(Arrays.asList(5, 5, 10, 20, 20, 25, 30, 30), rack.getBalls());

    }
}
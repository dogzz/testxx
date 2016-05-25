package com.company.j8inaction.apples;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/24/2016
*/
public class ApplesProcessorTest {
    List<Apple> inventory;
    ApplesProcessor processor;

    @Before
    public void setUp() {
        inventory = new ArrayList<>();
        inventory.add(new Apple("Green", 151));
        inventory.add(new Apple("Red", 150));
        processor = new ApplesProcessor();
    }

    @Test
    public void testWeightAppleFormatter() throws Exception {
        AppleFormatter formatter = new WeightAppleFormatter();
        String expected = "151 150 ";
        assertEquals(expected, processor.getApplesWithFormat(inventory, formatter));
    }

    @Test
    public void testWeightClassAppleFormatter() throws Exception {
        AppleFormatter formatter = new WeightClassAppleFormatter();
        String expected = "Green 151g => Heavy Red 150g => Light ";
        assertEquals(expected, processor.getApplesWithFormat(inventory, formatter));
    }

    @Test
    public void testWeightAppleFormatterLambda() throws Exception {
        String expected = "151 150 ";
        assertEquals(expected, processor.getApplesWithFormat(inventory, apple -> String.valueOf(apple.getWeight())));
    }

    @Test
    public void testWeightClassAppleFormatterLambda2() throws Exception {
        AppleFormatter formatter = apple -> {
            String result = "";
            result += apple.getColor() + " " + apple.getWeight() + "g => ";
            result += apple.getWeight() > 150 ? "Heavy" : "Light";
            return result;
        };
        String expected = "Green 151g => Heavy Red 150g => Light ";
        assertEquals(expected, processor.getApplesWithFormat(inventory, formatter));
    }
}
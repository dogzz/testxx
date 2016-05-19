package com.company.kata.k02binarychop;

import org.junit.Assert;
import org.junit.Test;

import static com.company.kata.k02binarychop.BinaryChop2.chop;

public class BinaryChop2Test {

    @Test
    public void testChop() throws Exception {
        Assert.assertEquals(-1, chop(3, new int[]{}));
        Assert.assertEquals(-1, chop(3, new int[]{1}));
        Assert.assertEquals(0,  chop(1, new int[]{1}));
        Assert.assertEquals(0,  chop(1, new int[]{1, 3, 5}));
        Assert.assertEquals(1,  chop(3, new int[]{1, 3, 5}));
        Assert.assertEquals(2,  chop(5, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(0, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(2, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(4, new int[]{1, 3, 5}));
        Assert.assertEquals(-1, chop(6, new int[]{1, 3, 5}));
        Assert.assertEquals(0,  chop(1, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(1,  chop(3, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(2,  chop(5, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(3,  chop(7, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(0, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(2, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(4, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(6, new int[]{1, 3, 5, 7}));
        Assert.assertEquals(-1, chop(8, new int[]{1, 3, 5, 7}));
    }
}
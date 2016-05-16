package com.company;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.company.BinaryChop1.chop;

/*
* Copyright Medtronic, Inc. 2014-2015
*
* MEDTRONIC CONFIDENTIAL - This document is the property of Medtronic,
* Inc.,and must be accounted for. Information herein is confidential. Do
* not reproduce it, reveal it to unauthorized persons, or send it outside
* Medtronic without proper authorization.
*/
public class BinaryChop1Test {

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
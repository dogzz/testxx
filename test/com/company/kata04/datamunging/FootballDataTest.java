package com.company.kata04.datamunging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
* Copyright Medtronic, Inc. 2014-2015
*
* MEDTRONIC CONFIDENTIAL - This document is the property of Medtronic,
* Inc.,and must be accounted for. Information herein is confidential. Do
* not reproduce it, reveal it to unauthorized persons, or send it outside
* Medtronic without proper authorization.
*/
public class FootballDataTest {
    FootballData data;

    @Before
    public void setUp() throws Exception {
        if (data == null) {
            data = new FootballData();
        }
    }

    @Test
    public void testGetReader() throws Exception {
        Assert.assertNotNull(data.getReader());
    }

    @Test
    public void testRawDataNotEmpty() {
        Assert.assertFalse(data.getRawData().isEmpty());
    }

    @Test
    public void testRowCounts() {
        Assert.assertEquals(20, data.getRawData().size());
    }

    @Test
    public void testGetHeaders() throws Exception {
        Assert.assertEquals("Team", data.getHeaders().get(1));
        Assert.assertEquals("F", data.getHeaders().get(6));
        Assert.assertEquals("A", data.getHeaders().get(7));
    }

    @Test
    public void testFirstRowContent() {
        Assert.assertEquals("Arsenal", data.getRawData().get(0).get("Team"));
        Assert.assertEquals("79", data.getRawData().get(0).get("F"));
        Assert.assertEquals("36", data.getRawData().get(0).get("A"));
    }

    @Test
    public void testGetScoredForTeam() {
        int actualMaxTemp = data.getScoredForTeam("Liverpool");
        Assert.assertEquals(67, actualMaxTemp);
    }

    @Test
    public void testGetScoredAgainstTeam() {
        int actualMinTemp = data.getScoredAgainstTeam("Liverpool");
        Assert.assertEquals(30, actualMinTemp);
    }

    @Test
    public void testGetScoreDifference() {
        int spread = data.getScoreDifference("Liverpool");
        Assert.assertEquals(37, spread);
    }

    @Test
    public void testGetTeamWithSmallestScoreDifference() {
        String team = data.getTeamWithSmallestScoreDifference();
        Assert.assertEquals("Aston_Villa", team);
    }
}
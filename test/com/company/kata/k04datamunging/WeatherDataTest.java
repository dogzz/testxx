package com.company.kata.k04datamunging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeatherDataTest {
    WeatherData data;

    @Before
    public void setUp() {
        if (data == null) {
            data = new WeatherData();
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
    public void testGetHeaders() throws Exception {
        Assert.assertEquals("Dy", data.getHeaders().get(0));
        Assert.assertEquals("MxT", data.getHeaders().get(1));
        Assert.assertEquals("MnT", data.getHeaders().get(2));
    }

    @Test
    public void testFirstRowContent() {
        Assert.assertEquals("1", data.getRawData().get(0).get("Dy"));
        Assert.assertEquals("88", data.getRawData().get(0).get("MxT"));
        Assert.assertEquals("59", data.getRawData().get(0).get("MnT"));
    }

    @Test
    public void testRowCounts() {
        Assert.assertEquals(30, data.getRawData().size());
    }

    @Test
    public void testGetMaxTempForDay() {
        int actualMaxTemp = data.getMaxTempForDay(2);
        Assert.assertEquals(79, actualMaxTemp);
    }

    @Test
    public void testGetMinTempForDay() {
        int actualMinTemp = data.getMinTempForDay(2);
        Assert.assertEquals(63, actualMinTemp);
    }

    @Test
    public void testGetSpreadForDay() {
        int spread = data.getSpreadForDay(2);
        Assert.assertEquals(16, spread);
    }

    @Test
    public void testGetDayWithSmallestSpread() {
        String day = data.getDayWithSmallestSpread();
        Assert.assertEquals("14", day);
    }
}
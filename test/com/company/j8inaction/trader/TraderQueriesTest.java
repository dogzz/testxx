package com.company.j8inaction.trader;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/30/2016
*/
public class TraderQueriesTest {

    TraderQueries queries;
    List<Transaction> transactions;
    private Trader raoul;
    private Trader mario;
    private Trader alan;
    private Trader brian;

    @Before
    public void setUp() {
        raoul = new Trader("Raoul", "Cambridge");
        mario = new Trader("Mario","Milan");
        alan = new Trader("Alan","Cambridge");
        brian = new Trader("Brian","Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        queries = new TraderQueries(transactions);
    }

    @Test
    public void testFindTransactionByYear() {
        List<Transaction> result = queries.getTransactionByYearSorted(2011);
        assertEquals(2, result.size());
        assertEquals(brian, result.get(0).getTrader());
        assertEquals(300, result.get(0).getValue());
        assertEquals(raoul, result.get(1).getTrader());
        assertEquals(400, result.get(1).getValue());
    }

    @Test
    public void testFindUniqueCities() {
        List<String> cities = queries.getUniqueCities();
        assertEquals(2, cities.size());
        assertTrue(cities.contains("Milan"));
        assertTrue(cities.contains("Cambridge"));
    }

    @Test
    public void testFindTradersByCityAndSort() {
        List<Trader> traders = queries.getTradersByCitySorted("Cambridge");
        assertEquals(3, traders.size());
        assertEquals(alan, traders.get(0));
        assertEquals(brian, traders.get(1));
        assertEquals(raoul, traders.get(2));
    }

    @Test
    public void testFindAllTradersNamesSorted() {
        String names = queries.getTradersNamesSorted();
        assertEquals("AlanBrianMarioRaoul", names);
    }

    @Test
    public void testIsAnyTraderBasedInCity() {
        boolean result = queries.isAnyTraderBasedInCity("Milan");
        assertTrue(result);
        result = queries.isAnyTraderBasedInCity("Paris");
        assertFalse(result);
    }

    @Test
    public void testFindAllTransactionValuesByCity() {
        List<Integer> result = queries.getAllTransactionValuesByCity("Cambridge");
        assertEquals(4, result.size());
        assertTrue(result.contains(300));
        assertTrue(result.contains(1000));
        assertTrue(result.contains(400));
        assertTrue(result.contains(950));
    }

    @Test
    public void testFindMaxTransactionValue() {
        assertEquals(1000, queries.getMaxTransactionValue());
    }

    @Test
    public void testFindMinTransaction() {
        assertEquals(transactions.get(0), queries.getMinTransaction());
    }

}
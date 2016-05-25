package com.company.kata.k08conflictingobjectives;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 5/23/2016
*/
public class ReadableSixLettersTest {
    ReadableSixLetters data;

    @Before
    public void setUp() {
        data = new ReadableSixLetters();
    }

    @Test
    public void testGetSixLettersWordNotEmpty() throws Exception {
        assertNotNull(data.getSixLettersWords());
        assertTrue(data.getSixLettersWords().size() > 0);
    }

    @Test
    public void testVerifyLettersCountInWords() {
        assertEquals(6, data.getSixLettersWords().get(0).length());
        assertEquals(6, data.getSixLettersWords().get(data.getSixLettersWords().size() - 1).length());
    }

    @Test
    public void testGetLessThanSixLettersWordNotEmpty() throws Exception {
        assertNotNull(data.getAllWords());
        assertTrue(data.getAllWords().size() > 0);
    }

    @Test
    public void testVerifyLettersCountInAllWords() {
        assertTrue(data.getAllWords().get(0).length() < 6);
        assertTrue(data.getAllWords().get(data.getAllWords().size() - 1).length() < 6);
    }

    @Test
    public void testDesiredWordProcessed() {
        List<String> result = data.getContainedWordsForWord("albums");
        assertEquals(2, result.size());
        assertEquals("al", result.get(0));
        assertEquals("bums", result.get(1));
    }

    @Test
    public void testUndesiredWordProcessed() {
        List<String> result = data.getContainedWordsForWord("qwerty");
        assertEquals(0, result.size());
    }

    @Test
    public void testAllWordsProcessed() {
        Map<String, List<String>> result = data.getContainedWordsForAllWords();
        assertNotNull(result);
        assertNotEquals(0, result.size());
        assertNotEquals(result.size(), data.getSixLettersWords().size());
        assertTrue(result.containsKey("albums"));
        List<String> expected = new ArrayList<>();
        expected.add("al");
        expected.add("bums");
        assertEquals(expected, result.get("albums"));
    }

}
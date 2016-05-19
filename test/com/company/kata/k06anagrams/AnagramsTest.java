package com.company.kata.k06anagrams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnagramsTest {
    Anagrams data;
    private List<String> testWords;

    @Before
    public void setUp() {
        data = new Anagrams();
        testWords = new ArrayList<>();
        testWords.add("enlist");
        testWords.add("inlets");
        testWords.add("wrong");
        testWords.add("listen");
        testWords.add("silent");
    }

    @Test
    public void testWordsListSize() {
        assertNotNull(data.getWordsList());
        assertEquals(338882, data.getWordsList().size());
    }

    @Test
    public void testFindLettersForWord() {
        String word = "enlist";
        List<Character> letters = data.getLettersForWord(word);
        assertEquals(6, letters.size());
        for (int i = 0; i < word.length(); i++) {
            assertTrue("Verify that letter <" + word.charAt(i) + "> is present", letters.contains(word.charAt(i)));
        }
    }

    @Test
    public void testFindAnagramsForWord() {
        data.setWordsList(testWords);
        List<String> anagrams = data.getAnagramsForWord(testWords.get(0));
        assertEquals(4, anagrams.size());
        assertTrue(anagrams.contains("enlist"));
        assertTrue(anagrams.contains("inlets"));
        assertTrue(anagrams.contains("listen"));
        assertTrue(anagrams.contains("silent"));
        assertFalse(anagrams.contains("wrong"));
    }

    @Test
    public void testProcessedAnagramsRemoved() {
        data.setWordsList(testWords);
        data.getAnagramsForWord(testWords.get(0));
        assertEquals(1, data.getWordsList().size());
        assertTrue(data.getWordsList().contains("wrong"));
        assertFalse(data.getWordsList().contains(testWords.get(0)));
        assertFalse(data.getWordsList().contains("silent"));
    }

    @Test
    public void testFindAnagramsForTwoWords() {
        testWords.add("boaster");
        testWords.add("moharrams");
        testWords.add("boaters");
        testWords.add("borates");
        testWords.add("ethograms");
        data.setWordsList(testWords);
        List<String> anagrams = data.getAnagramsForWords();
        assertEquals(2, anagrams.size());
        assertTrue(anagrams.contains("boaster boaters borates "));
        assertTrue(anagrams.contains("enlist inlets listen silent "));
    }

    @Test
    public void findAnagramsFromFileForWord() {
        List<String> anagrams = data.getAnagramsForWord("boaster");
        assertEquals(6, anagrams.size());
        assertEquals("barotse", anagrams.get(0));
        assertEquals("boaster", anagrams.get(1));
        assertEquals("boaters", anagrams.get(2));
        assertEquals("borates", anagrams.get(3));
        assertEquals("rebatos", anagrams.get(4));
        assertEquals("sorbate", anagrams.get(5));
    }

    @Test
    public void testFindAnagramsFromFile() {
        int anagramsCount = data.getAnagramsCount();
        List<String> anagrams = data.getAnagramsForWords();
        assertEquals(anagramsCount, anagrams.size());
        assertTrue(anagrams.contains("barotse boaster boaters borates rebatos sorbate "));
    }

    @Test
    public void testAnagramsCount() {
        int result = data.getAnagramsCount();
        assertEquals(30404, result);
    }
}
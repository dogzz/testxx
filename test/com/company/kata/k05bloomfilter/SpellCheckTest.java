package com.company.kata.k05bloomfilter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpellCheckTest {
    SpellCheck spellCheck;
    List<String> correctWords;
    List<String> incorrectWords;
    BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        spellCheck = new SpellCheck();
        reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
        correctWords = new ArrayList<>();
        incorrectWords = new ArrayList<>();
        correctWords.add(reader.lines().findAny().orElse("preambulate"));
        correctWords.add(reader.lines().findAny().orElse("loudliest"));
        correctWords.add(reader.lines().findAny().orElse("discipline"));
        correctWords.add(reader.lines().findAny().orElse("teemingly"));
        incorrectWords.add("asdfg");
        incorrectWords.add("teeminglywe");
        incorrectWords.add("qwtr");
        incorrectWords.add("hjk");
    }

    @Test
    public void testVectorNotNull() throws Exception {
        Assert.assertNotNull(spellCheck.getVector());
    }

    @Test
    public void testVectorSize() throws Exception {
        Assert.assertTrue(spellCheck.getVector().size() != 0);
    }

    @Test
    public void testReaderNotNull() throws Exception {
        Assert.assertNotNull(spellCheck.getReader());
    }

    @Test
    public void testCorrectWords() throws Exception {
        for (String s : correctWords) {
            Assert.assertTrue("Verify that word " + s + " is correct", spellCheck.isWordCorrect(s));
        }
    }

    @Test
    public void testIncorrectWords() throws Exception {
        for (String s : incorrectWords) {
            Assert.assertFalse("Verify that word " + s + " is incorrect", spellCheck.isWordCorrect(s));
        }
    }

    @Test
    public void testEfficiencyOfBloomFilter() throws Exception  {
        long startTime = new Date().getTime();
        Assert.assertTrue(spellCheck.isWordCorrect("teemingly"));
        long endTime = new Date().getTime();
        long bloomResult = endTime - startTime;
        reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
        startTime = new Date().getTime();
        Assert.assertTrue(reader.lines().anyMatch(s -> {
            return s.equals("teemingly");
        }));
        endTime = new Date().getTime();
        long iterativeResult = endTime - startTime;
        System.out.println("The Bloom result is " + bloomResult + "; The itertive result is " + iterativeResult);
        Assert.assertTrue(bloomResult < iterativeResult);
    }
}
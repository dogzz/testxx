package com.company.kata.k13countingcodelines;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 7/11/2016
*/
public class CodeLinesCounterTest {
    CodeLinesCounter counter;

    @Before
    public void setUp() throws Exception {
        counter = new CodeLinesCounter();
    }

    @Test
    public void getLinesOfCodeFirst() throws Exception {
        String source = readStringsFromFile("resources\\sourceFile1.java");
        int result = counter.getLinesOfCode(source);
        assertThat(result, is(3));
    }

    @Test
    public void getLinesOfCodeSecond() throws Exception {
        String source = readStringsFromFile("resources\\sourceFile2.java");
        int result = counter.getLinesOfCode(source);
        assertThat(result, is(5));
    }

    private String readStringsFromFile(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String lines = reader.lines()
                .collect(Collectors.joining("\n"));
        return lines;
    }

}
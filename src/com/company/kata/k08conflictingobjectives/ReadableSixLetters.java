/*
* @Author: dogzz
* @Created: 5/23/2016
*/

package com.company.kata.k08conflictingobjectives;

import com.company.kata.k05bloomfilter.SpellCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ReadableSixLetters {
    SpellCheck spellChecker = new SpellCheck();
    List<String> sixLettersWords = new ArrayList<>();
    List<String> allWords = new ArrayList<>();

    public ReadableSixLetters() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
            sixLettersWords = getAllSixLettersWords(reader);
            reader.close();
            reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
            allWords = getAllWordsWithLessTnanSixLetters(reader);
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getAllWordsWithLessTnanSixLetters(BufferedReader reader) {
        List<String> result;
        result = reader.lines().parallel()
                .filter(s -> s.length() < 6)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        return result;
    }

    private List<String> getAllSixLettersWords(BufferedReader reader) {
        List<String> result;
        result = reader.lines().parallel()
                .filter(s -> s.length() == 6)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> getSixLettersWords() {
        return sixLettersWords;
    }

    public List<String> getAllWords() {
        return allWords;
    }

    public List<String> getContainedWordsForWord(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String firstWord = word.substring(0, i + 1);
            String secondWord = word.substring(i + 1);
            if (spellChecker.isWordCorrect(firstWord) && spellChecker.isWordCorrect(secondWord)) {
                if (allWords.contains(firstWord) && allWords.contains(secondWord)) {
                    result.add(firstWord);
                    result.add(secondWord);
                    return result;
                }
            }
        }
        return result;
    }

    public Map<String, List<String>> getContainedWordsForAllWords() {
        Map<String, List<String>> result = new HashMap<>();
        sixLettersWords.stream().forEach(word -> {
            List<String> containedWords = getContainedWordsForWord(word);
            if (!containedWords.isEmpty()) result.put(word, containedWords);
        });
        return result;
    }
}

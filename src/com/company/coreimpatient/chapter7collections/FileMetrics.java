package com.company.coreimpatient.chapter7collections;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 7. Write a program that reads all words in a file and prints out how often each word
 occurred. Use a TreeMap<String, Integer>.
 8. Write a program that reads all words in a file and prints out on which line(s) each of
 them occurred. Use a map from strings to sets.
 * Created by afon on 04.09.2016.
 */
public class FileMetrics {
    public static void main(String...args) {
        FileMetrics fm = new FileMetrics();
        System.out.println(fm.getWordsCount("resources/LICENSE"));
        System.out.println(fm.getWordsLines("resources/LICENSE"));
    }

    public Map<String, Integer> getWordsCount(String fileName) {
        Map<String, Integer> result = new TreeMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.size();
            for (String line: lines) {
                String[] words = line.toLowerCase().split("[\\p{Space}\\p{Punct}\\p{Digit}]");
                for (String word : words) {
                    if (word.length() > 0) {
//                        if (result.get(word) != null) {
//                            int n = result.get(word) + 1;
//                            result.put(word, n);
//                        } else {
//                            result.put(word, 1);
//                        }
                        result.merge(word, 1, Integer::sum);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<String, Set<Integer>> getWordsLines(String fileName) {
        Map<String, Set<Integer>> result = new TreeMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.size();
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] words = line.toLowerCase().split("[\\p{Space}\\p{Punct}\\p{Digit}]");
                for (String word : words) {
                    if (word.length() > 0) {
                        if (result.get(word) != null) {
                            Set<Integer> s = result.get(word);
                            s.add(i);
                        } else {
                            Set<Integer> s = new TreeSet<>();
                            s.add(i);
                            result.put(word, s);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

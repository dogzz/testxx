/*
* @Author: dogzz
* @Created: 9/6/2016
*/

package com.company.coreimpatient.chapter8streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String...args) {
        Streams s = new Streams();
        Stream<Long> str = s.infinite(25214903917L, 11, 2^48, 5);
//        str.forEach(s1 -> System.out.println(s1));
        s.firstHundredWords("resources/wordlist.txt");
        System.out.println(s.getAvg("resources/wordlist.txt"));
        List<String> l = s.getMax("resources/wordlist.txt");
        System.out.println(l);
    }

    public Stream<Long> infinite(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a*x + c)%m);
    }

    public boolean isWord(String text) {
        return text.codePoints().allMatch(Character::isAlphabetic);
    }

    public void firstHundredWords(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.stream()
                    .filter(this::isWord)
                    .limit(100)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Integer getAvg(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            int z = lines.stream()
                    .map(String::length)
                    .reduce(0, (x, y) -> (x + y));
            return z / lines.size();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getMax(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            int z = lines.stream()
                    .map(String::length)
                    .reduce(Integer::max).get();
            return lines.stream()
                    .filter(s -> s.length() == z)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

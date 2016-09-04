package com.company.coreimpatient.chapter7collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1 1. Write a program that reads a sentence into an array list. Then, using
 Collections.shuffle, shuffle all but the first and last word, without copying
 the words into another collection.
 12. Using Collections.shuffle, write a program that reads a sentence, shuffles
 the words, and prints the result. Fix the capitalization of the initial word and the
 punctuation of the last word (before and after the shuffle). Hint: Don’t shuffle the
 words.
 * Created by afon on 04.09.2016.
 */
public class Shuffles {
    public static void main(String...args) {
        Shuffles sh = new Shuffles();
        String sen = "A POSIX locale can have collating sequences to describe how certain characters or groups of characters should be ordered.";
        System.out.println(sh.shuffleSentence(sen));
        System.out.println(sh.shuffleSentenceToString(sen));
    }

    public List<String> shuffleSentence(String origin) {
        List<String> words = Arrays.asList(origin.split("[\\p{Space}\\p{Punct}\\p{Digit}]"));
        Collections.shuffle(words.subList(1, words.size() - 1));
        return words;
    }

    public String shuffleSentenceToString(String origin) {
        List<String> words2 = Arrays.asList(origin.split("[\\p{Space}\\p{Punct}\\p{Digit}]"));
        List<String> words = new ArrayList<>(words2);
        words.add(0, words.get(0).toLowerCase());
        words.remove(1);
        Collections.shuffle(words);
        String firstWord = words.get(0);
        String letter = firstWord.substring(0, 1);
        letter = letter.toUpperCase();
        firstWord = letter + firstWord.substring(1, firstWord.length());
        words.add(0, firstWord);
        words.remove(1);
        words.add(words.size() - 1, words.get(words.size() - 1) + ".");
        words.remove(words.size() - 1);
        String result = "";
        for (String word : words) {
            result = result + word + " ";
        }
        return result;
    }
}

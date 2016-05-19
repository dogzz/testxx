package com.company.kata.k06anagrams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Anagrams {

    private List<String> wordsList = new ArrayList<>();
    private List<Integer> wordsCheckSum = new ArrayList<>();

    public Anagrams() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
            wordsList.addAll(reader.lines().filter(line -> !line.isEmpty() && !line.equals("-"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList()));
            generateWordsCheckSum();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int getWordCheckSum(String word) {
        char[] lowerCaseCharacters = word.toLowerCase().toCharArray();
        int result = 0;
        for (char c : lowerCaseCharacters) {
            result += c;
        }
        return result;
    }

    public List<String> getAnagramsForWord(String word) {
        List<String> result = new ArrayList<>();
        int checkSum = getWordCheckSum(word);
        int wordIndex = wordsCheckSum.indexOf(checkSum);
        int previousIndex = 0;
        while (wordIndex != -1) {
            List<Character> letters = getLettersForWord(word);
            Collections.sort(letters);
            String wordFound = wordsList.get(wordIndex + previousIndex);
            if (isWordConsistsOfLetters(wordFound, letters)) {
                wordsCheckSum.remove(wordIndex + previousIndex);
                wordsList.remove(wordFound);
                wordIndex = 0;
                result.add(wordFound);
            } else {
                wordIndex++;
            }
            previousIndex = wordIndex + previousIndex;
            wordIndex = wordsCheckSum.subList(previousIndex, wordsCheckSum.size()).indexOf(checkSum);
        }
        return result;
    }

    private boolean isWordConsistsOfLetters(String word, List<Character> letters) {
        char[] lowerCasedWord = word.toLowerCase().toCharArray();
        List<Character> wordAsList = new ArrayList<>();
        for (char c : lowerCasedWord) {
            wordAsList.add(c);
        }
        Collections.sort(wordAsList);
        return wordAsList.size() == letters.size() && wordAsList.equals(letters);
    }

    List<Character> getLettersForWord(String word) {
        List<Character> result = new ArrayList<>();
        String lowerCasedWord = word.toLowerCase();
        for (int i = 0; i < lowerCasedWord.length(); i++) {
            result.add(lowerCasedWord.charAt(i));
        }
        return result;
    }

    public List<String> getAnagramsForWords() {
        List<String> result = new ArrayList<>();
        List<String> copyOfLookupWords = new ArrayList<>();
        copyOfLookupWords.addAll(wordsList);
        copyOfLookupWords.stream().forEach(word -> {
            StringBuilder resultString = new StringBuilder();
            getAnagramsForWord(word).stream().forEach(anagram -> resultString.append(anagram).append(" "));
            if (!resultString.toString().isEmpty() && !resultString.toString().equals(word + " ")) {
                result.add(resultString.toString());
            }
        });
        return result;
    }

    public int getAnagramsCount() {
        List<String> sortedList = getSortedList();
        Set<String> anagramsCombinations = new HashSet<>();
        for (int i = 1; i < sortedList.size(); i++) {
            if (sortedList.get(i - 1).equals(sortedList.get(i))) {
                anagramsCombinations.add(sortedList.get(i));
            }
        }
        return anagramsCombinations.size();
    }

    private List<String> getSortedList() {
        List<String> result = new ArrayList<>();
        for (String word: wordsList) {
            List<Character> letters = getLettersForWord(word);
            Collections.sort(letters);
            String s = "";
            for (Character chr : letters) {
                s += chr;
            }
            result.add(s);
        }
        Collections.sort(result);
        return result;
    }

    public List<String> getWordsList() {
        return wordsList;
    }

    void setWordsList(List<String> wordsList) {
        this.wordsList.clear();
        this.wordsList.addAll(wordsList);
        generateWordsCheckSum();
    }

    private void generateWordsCheckSum() {
        wordsCheckSum.clear();
        wordsCheckSum.addAll(wordsList.stream().map(this::getWordCheckSum).collect(Collectors.toList()));
    }
}

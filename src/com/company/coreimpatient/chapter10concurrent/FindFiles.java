/*
* @Author: dogzz
* @Created: 10/25/2016
*/

package com.company.coreimpatient.chapter10concurrent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindFiles {

    public static void main(String...args) {
        String word = "TFH";
        List<File> allFiles = Arrays.asList(new File("./resources/").listFiles());
        allFiles.forEach(System.out::println);
        List<String> result = allFiles.parallelStream()
                .filter(f -> isWordPresentInFile(f, word))
                .map(File::getName)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    public static boolean isWordPresentInFile(File file, String word) {
        try {
            if (!file.isDirectory()) {
                BufferedReader f = new BufferedReader(new FileReader(file));
                return f.lines().filter(s -> s.contains(word)).findAny().isPresent();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

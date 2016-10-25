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

public class FindWord {

    public static void main(String...args) {
        String word = "A";
        List<File> allFiles = Arrays.asList(new File("./resources/").listFiles());
        for (File f: allFiles) {
            Runnable r = () -> {
                try {
                    if (!f.isDirectory()) {
                        BufferedReader reader = new BufferedReader(new FileReader(f));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println("Interrupted " + f.getName() + ": Already found");
                                return;
                            } else {
                                if (line.contains(word)) {
                                    System.out.println("Found in file " + f.getName());
                                    Thread.currentThread().interrupt();
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("Interrupted");
                    Thread.currentThread().interrupt();
                }
            };
            new Thread(r).run();
        }
    }
}

/*
* @Author: dogzz
* @Created: 10/25/2016
*/

package com.company.coreimpatient.chapter10concurrent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Write an application in which multiple threads read all words from a collection of
 * files. Use a ConcurrentHashMap<String, Set<File>> to track in which
 * files each word occurs. Use the merge method to update the map.
 *
 * Repeat the preceding exercise, but use computeIfAbsent instead.
 */

public class ReadWrodsFromFiles {

    ConcurrentHashMap<String, Set<File>> mapa = new ConcurrentHashMap<>();
    public static void main(String...args) {
        ReadWrodsFromFiles mn = new ReadWrodsFromFiles();
        try {
            mn.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void run() throws Exception{
        List<File> allFiles = Arrays.asList(new File("./resources/").listFiles());
        allFiles.forEach(f -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(f));
                        String line;
                        while ((line = br.readLine()) != null) {
                            List<String> words = Arrays.asList(line.split("\\W"));
                            for (String word : words) {
                                if (!word.isEmpty()) {
                                    Set<File> files = new HashSet<>();
                                    files.add(f);
                                    mapa.merge(word, files, (f, v) -> {
                                        f.addAll(v);
                                        return f;
                                    });
                                }
                            }
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("File " + f.getName() + " processed.");
                }
            }).run();
        });

    }
}

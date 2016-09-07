/*
4. Using a Scanner is convenient, but it is a bit slower than using a
BufferedReader. Read in a long file a line at a time, counting the number of
input lines, with (a) a Scanner and hasNextLine/nextLine, (b) a
BufferedReader and readLine, (c) a bufferedReader and lines.
* @Author: dogzz
* @Created: 9/7/2016
*/

package com.company.coreimpatient.chapter9io;

import com.company.coreimpatient.chapter7collections.FileMetrics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FileTricks {
    public static void main(String...args) throws IOException {
        FileTricks ft = new FileTricks();
//        ft.createIndex("resources/LICENSE.txt");

        ft.countTime(f-> {
            int counter = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line;
                while ((line = reader.readLine()) != null) {
                    counter++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(counter);
        });

        ft.countTime(f-> {
            long counter = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                counter = reader.lines().count();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            System.out.println(counter);
        });

        ft.countTime(f-> {
            int counter = 0;
            Scanner scanner = null;
            try {
                scanner = new Scanner(Paths.get(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                counter++;
            }
//            System.out.println(counter);
        });


    }

    public void createIndex(String fileName) throws IOException {
        FileMetrics metrics = new FileMetrics();
        Map<String, Set<Integer>> result =  metrics.getWordsLines(fileName);
        List<String> keys = result.keySet().stream().sorted().collect(Collectors.toList());
        FileWriter f = new FileWriter(fileName.substring(0, fileName.lastIndexOf('.')) + ".toc");
        for (String word : keys) {
            f.write(word + result.get(word).toString());
            f.write("\n");
        }
    }

    public void countTime(Consumer<String> cons) {
        Instant start = Instant.now();
        for (int i = 1; i < 100; i++) {
            cons.accept("resources/LICENSE.txt");
        }
        Instant end = Instant.now();
        Duration seconds = Duration.between(start, end);
        System.out.println("Duration is " + seconds.getNano());
    }
}

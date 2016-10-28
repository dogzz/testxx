/*
* @Author: dogzz
* @Created: 10/28/2016
*/

package com.company.coreimpatient.chapter10concurrent;

import java.awt.image.renderable.RenderableImageProducer;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QueueProcessing {

    private BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(5);


    public static void main(String...args) {
        QueueProcessing processor = new QueueProcessing();
        List<File> allFiles = Arrays.asList(new File("./resources/").listFiles());
        String word = "Liverpool";
//        IntStream str = word.chars().filter(c -> c == 'o');
//        str.forEach(System.out::println);
        processor.findWord(word, allFiles);
        processor.mostCommonWords(allFiles);
    }

    /*
    * Use a blocking queue for processing files in a directory. One thread walks the file
    * tree and inserts files into a queue. Several threads remove the files and search each
    * one for a given keyword, printing out any matches. When the producer is done, it
    * should put a dummy file into the queue.
     */
    private void findWord(String word, List<File> allFiles){
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (File f : allFiles) {
                    try {
                        blockingQueue.put(f);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                try {
                    blockingQueue.put(new File("dummy"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        Runnable consumerRunnable = () -> {
            try {

                File f = blockingQueue.take();
                while (!f.getName().contains("dummy")) {
                    if (FindFiles.isWordPresentInFile(f, word)) {
                        System.out.printf("Word %s found in file %s", word, f.getName());
                        System.out.println();
                    }
                    f = blockingQueue.take();
                }
                String s;
                try {
                    blockingQueue.put(new File("dummy"));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Finished.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };

        new Thread(consumerRunnable).start();
        new Thread(consumerRunnable).start();
        producer.start();
        new Thread(consumerRunnable).start();
    }

    /*
    * Repeat the preceding exercise, but instead have each consumer compile a map of
    * words and their frequencies that are inserted into a second queue. A final thread
    * merges the dictionaries and prints the ten most common words. Why don’t you need
    * to use a ConcurrentHashMap?
     */
    private void mostCommonWords(List<File> allFiles) {

    }
}

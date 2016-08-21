package com.company.coreimpatient.chapter3oop;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by afon on 21.08.2016.
 */
public class FileWork {
    public static void main(String...args) {
        FileWork fw = new FileWork();

        fw.printPngInDir("D:\\Download");

    }

    public void printSubdirectoriesLambda(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles(f -> f.isDirectory());
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

    public void printSubdirectoriesMR(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles(File::isDirectory);
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

    public void printSubdirectoriesInner(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        for (File f : files) {
            System.out.println(f.getName());
        }
    }

    public void printPngInDir(String dir) {
        File file = new File(dir);
        String[] files = file.list((d, name) -> name.endsWith(".png"));
        for (String f : files) {
            System.out.println(f);
        }
    }

}

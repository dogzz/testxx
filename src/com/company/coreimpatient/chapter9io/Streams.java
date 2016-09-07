/*
* @Author: dogzz
* @Created: 9/7/2016
*/

package com.company.coreimpatient.chapter9io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Streams {
    public static void main(String...args) throws IOException {
        InputStream is = System.in;
        OutputStream os = System.out;
//        int c;
//        while ((c = is.read()) != -1) {
//            os.write(c);
//        }
        Files.copy(is, Paths.get("resources/temp.txt"));
        Files.copy(Paths.get("resources/temp.txt"), os);
    }
}

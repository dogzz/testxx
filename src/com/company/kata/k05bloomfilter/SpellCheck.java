package com.company.kata.k05bloomfilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class SpellCheck {
    private BitSet vector;
    private BufferedReader reader;
    private int linesCount;
    public final static int vectorMultiplier = 3;
    MessageDigest md;

    public SpellCheck() {
        try {
            reader = new BufferedReader(new FileReader(new File("resources\\wordlist.txt")));
            md = MessageDigest.getInstance("MD5");
            linesCount = 400000; //(int) reader.lines().count();
            vector = generateBitVector(reader);
        } catch (FileNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private BitSet generateBitVector(BufferedReader reader) {
        vector = new BitSet(linesCount * vectorMultiplier);
        reader.lines().forEach(s -> {
            vector.set(getHash1(s), true);
            vector.set(getHash2(s), true);
            vector.set(getHash3(s), true);
        });
        reader.lines().close();
        return vector;
    }

    public int getHash1(String word) {
        return Math.abs(word.hashCode());
    }

    public int getHash2(String word) {
        md.update(word.getBytes());
        byte[] reducedHash = md.digest();
        return new BigInteger(1, new byte[] {reducedHash[0], reducedHash[1]}).intValue();
    }

    public int getHash3(String word) {
        md.update(word.getBytes());
        byte[] reducedHash = md.digest();
        return new BigInteger(1, new byte[] {reducedHash[2], reducedHash[3]}).intValue();
    }

    public BitSet getVector() {
        return vector;
    }

    public BufferedReader getReader() {
        return reader;
    }


    public int getLinesCount() {
        return linesCount;
    }

    public boolean isWordCorrect(String word) {
        return vector.get(getHash1(word))
                && vector.get(getHash2(word))
                && vector.get(getHash3(word));
    }
}

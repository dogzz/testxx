package com.company.coreimpatient.chapter7collections;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * s
 * Created by afon on 04.09.2016.
 */
public class Erathostene {

    private List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            temp.add(i);
        }
        int p = 2;
        while (p > 0) {
            for (int j = 2*p; j <= n; j = j + p) {
                temp.remove(j);
            }

            p = getNext(p, temp);
        }
        result.addAll(temp);
        return result;
    }

    private int getNext(int p, Set<Integer> temp) {
        for (int i = 1; i < temp.size(); i++) {
            if (temp.contains(p + i)) {
                return p + i;
            }
        }
        return -1;
    }

    private List<String> toUppercaseIterator(List<String> origin) {
        List<String> cop = new ArrayList<>();
//        Collections.copy(cop, origin);
        Iterator<String> iter = origin.iterator();
        while (iter.hasNext()) {
            cop.add(iter.next().toUpperCase());
        }
        return cop;
    }

    private List<String> toUppercaseLoop(List<String> origin) {
        List<String> cop = new ArrayList<>();
        for (int i = 0; i < origin.size(); i++) {
            cop.add(origin.get(i).toUpperCase());
        }
        return cop;
    }

    private List<String> toUppercaseReplace(List<String> origin) {
        List<String> cop = new ArrayList<>(origin);
//        Collections.copy(cop, origin);
        cop.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        return cop;
    }

    public static void main(String...args) {
        Erathostene er = new Erathostene();
        System.out.println("Primes:");
        System.out.println(er.getPrimes(100));
        List<String> orig = Arrays.asList("java", "training", "good");
        System.out.println("Original:");
        System.out.println(orig);
        System.out.println("Iterator");
        System.out.println(er.toUppercaseIterator(orig));
        System.out.println("Original:");
        System.out.println(orig);
        System.out.println("Loop");
        System.out.println(er.toUppercaseLoop(orig));
        System.out.println("Original:");
        System.out.println(orig);
        System.out.println("ReplaceAll");
        System.out.println(er.toUppercaseReplace(orig));
        System.out.println("Original:");
        System.out.println(orig);
    }
}

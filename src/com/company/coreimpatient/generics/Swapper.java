/*
* @Author: dogzz
* @Created: 8/22/2016
*/

package com.company.coreimpatient.generics;

import java.util.*;
import java.util.function.Function;

public class Swapper{
    public static void main(String...args) {
        Double[] result = Swapper.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        System.out.println(Arrays.toString(result));
        List<Double> elems = Arrays.asList(0.0, 1.0, 1.5, 2.0, 3.0);
        List<Number> results = new ArrayList<>();
        minmax(elems, Comparator.naturalOrder(), results);
        System.out.println(results);
        System.out.println(map(elems,
                d -> "Item: ".concat(d.toString())));
        System.out.println(Arrays.toString(repeat(3, 0.0, 1.0, 1.5, 2.0, 3.0)));
    }

    public static <T> T[] swap(int i, int j, T...values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static <T> void minmax(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        Optional<T> max = elements.stream().max(comp);
        Optional<T> min = elements.stream().min(comp);
        result.add(min.orElse(null));
        result.add(max.orElse(null));
    }

    public static <T, R> List<R> map(List<T> original, Function<T, R> func) {
        List<R> result = new ArrayList<R>();
        for (T item : original) {
            result.add(func.apply(item));
        }
        return result;
    }

    @SafeVarargs
    public static final <T> T[] repeat(int n, T...objs) {
        int size = n * objs.length;
        T[] t = Arrays.copyOf(objs, size);
        int count = 0;
        for (int i = objs.length; i < size; i++) {
            t[i] = objs[count];
            count++;
            if (count >= objs.length) count = 0;
        }
        return t;
    }
}

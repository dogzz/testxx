/*
* @Author: dogzz
* @Created: 9/6/2016
*/

package com.company.coreimpatient.chapter7collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

public class Views {

    public static void main(String...args) {
        Views v = new Views();
        List<Integer> lst = v.getNumbers(20, i -> i*2);
        System.out.println(lst);
        System.out.println(lst.size());

    }

    private List<Integer> getNumbers(int n, IntFunction<Integer> func) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lst.add(func.apply(i));
        }
        return Collections.unmodifiableList(lst);
    }
}

/*
* @Author: dogzz
* @Created: 10/28/2016
*/

package com.company.coreimpatient.chapter10concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrent {

    public static ConcurrentHashMap<String, Long> mapa;

    public static void main (String...args) {
        mapa = new ConcurrentHashMap<>();
        mapa.put("1", 500L);
        mapa.put("2", 500L);
        mapa.put("3", 501L);
        mapa.put("4", 500L);
        System.out.println(getMaxKey());
    }

    static String getMaxKey() {
        Map.Entry<String, Long> e = mapa.reduceEntries(4, (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2);
        return e.getKey();
    }
}

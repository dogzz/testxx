/*
* @Author: dogzz
* @Created: 8/22/2016
*/

package com.company.coreimpatient.generics;

import java.util.ArrayList;

public class Table<K, V> {
    private ArrayList<Entry> list = new ArrayList<>();

    public V get(K key) {
        int i = list.indexOf(new Entry(key, null));
        if (i >= 0) {
            return list.get(i).value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (isKeyExists(key)) {
            int i = list.indexOf(new Entry(key, null));
            list.get(i).value = value;
        } else {
            list.add(new Entry(key, value));
        }
    }

    public boolean remove(K key) {
        return list.remove(new Entry(key, null));
    }

    private boolean isKeyExists(K key) {
        return list.contains(new Entry(key, null));
    }

    public class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != Entry.class) {
                return false;
            }
            Entry entry = (Entry) obj;
            return entry.key.equals(this.key);
        }
    }
}

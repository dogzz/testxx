package com.company.coreimpatient.generics;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 8/22/2016
*/
public class EntryTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void equals() throws Exception {
        Table<String, String>.Entry entry1 = new Table<String, String>().new Entry("key1", "value1");
        Table<String, String>.Entry entry2 = new Table<String, String>().new Entry("key1", "sdsdsdsd");
        assertThat(entry1.equals(entry2), is(true));
        assertThat(entry2.equals(entry1), is(true));
    }

    @Test
    public void notEquals() throws Exception {
        Table<String, String>.Entry entry1 = new Table<String, String>().new Entry("key1", "value1");
        Table<String, String>.Entry entry2 = new Table<String, String>().new Entry("key2", "value1");
        assertThat(entry1.equals(entry2), is(false));
        assertThat(entry2.equals(entry1), is(false));
    }

    @Test
    public void equalsNullValue() throws Exception {
        Table<String, String>.Entry entry1 = new Table<String, String>().new Entry("key1", null);
        Table<String, String>.Entry entry2 = new Table<String, String>().new Entry("key1", null);
        Table<String, String>.Entry entry3 = new Table<String, String>().new Entry("key2", null);
        assertThat(entry1.equals(entry2), is(true));
        assertThat(entry2.equals(entry3), is(false));
    }

}
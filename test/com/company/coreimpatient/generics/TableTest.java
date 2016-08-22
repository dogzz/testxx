package com.company.coreimpatient.generics;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 8/22/2016
*/
public class TableTest {

    Table<Integer, String> intTable;
    Table<String, String> stringTable;

    @Before
    public void setUp() throws Exception {
        intTable = new Table<>();
        stringTable = new Table<>();
        intTable.put(1, "Value1");
        stringTable.put("Key1", "ValueK1");
    }

    @Test
    public void get() throws Exception {
        assertThat(intTable.get(1), is("Value1"));
        assertThat(stringTable.get("Key1"), is("ValueK1"));
        assertThat(intTable.get(2), nullValue());
    }

    @Test
    public void put() throws Exception {
        intTable.put(2, "Value1asdasd");
        stringTable.put("Key2", "ValueK1asdasd");
        assertThat(intTable.get(2), is("Value1asdasd"));
        assertThat(stringTable.get("Key2"), is("ValueK1asdasd"));
    }

    @Test
    public void remove() throws Exception {
        intTable.put(2, "Value1asdasd");
        stringTable.put("Key2", "ValueK1asdasd");
        intTable.remove(1);
        stringTable.remove("Key1");
        assertThat(intTable.get(2), is("Value1asdasd"));
        assertThat(stringTable.get("Key2"), is("ValueK1asdasd"));
        assertThat(intTable.get(1), nullValue());
        assertThat(stringTable.get("Key1"), nullValue());
    }

}
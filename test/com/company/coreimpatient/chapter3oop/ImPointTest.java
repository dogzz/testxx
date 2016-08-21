package com.company.coreimpatient.chapter3oop;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by afon on 21.08.2016.
 */
public class ImPointTest {

    @Test
    public void test1() {
        ImPoint p = new ImPoint(3, 4);
        p.translate(1, 3).scale(0.5);
        assertThat(p.getX(), is(2.0));
        assertThat(p.getY(), is(3.5));
    }

}
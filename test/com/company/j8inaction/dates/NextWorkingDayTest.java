package com.company.j8inaction.dates;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/*
* @Author: dogzz
* @Created: 9/7/2016
*/
public class NextWorkingDayTest {
    @Test
    public void adjustInto() throws Exception {
        LocalDate date1 = LocalDate.of(2016, 9, 7);
        date1 = date1.with(new NextWorkingDay());
        assertThat(date1, is(LocalDate.of(2016, 9, 8)));
        LocalDate date2 = LocalDate.of(2016, 9, 9);
        date2 = date2.with(new NextWorkingDay());
        assertThat(date2, is(LocalDate.of(2016, 9, 12)));
        date2 = LocalDate.of(2016, 9, 10);
        date2 = date2.with(new NextWorkingDay());
        assertThat(date2, is(LocalDate.of(2016, 9, 12)));
        date2 = LocalDate.of(2016, 9, 11);
        date2 = date2.with(new NextWorkingDay());
        assertThat(date2, is(LocalDate.of(2016, 9, 12)));
    }

}
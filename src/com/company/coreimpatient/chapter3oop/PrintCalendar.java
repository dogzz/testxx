package com.company.coreimpatient.chapter3oop;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by afon on 21.08.2016.
 */
public class PrintCalendar {
    public static void main(String...args) {
        print();
    }

    private static void print() {
        LocalDate date = LocalDate.of(2016, 7, 1);
        DayOfWeek[] days = DayOfWeek.values();
        System.out.print(" " + days[6].getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        for (int i = 0; i < 6; i ++) {
            System.out.print(" " + days[i].getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        }
        System.out.println("");
        int weekdate = date.getDayOfWeek().getValue();
        for (int i = 1; i <= weekdate; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == 7) {
            System.out.printf("%4d", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) System.out.println("");
            date = date.plusDays(1);


        }
    }
}

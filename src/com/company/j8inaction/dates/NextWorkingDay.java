/*
* @Author: dogzz
* @Created: 9/7/2016
*/

package com.company.j8inaction.dates;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        temporal = temporal.plus(1, ChronoUnit.DAYS);
        if (temporal.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SATURDAY.getValue()) {
            temporal = temporal.plus(2, ChronoUnit.DAYS);
        }
        if (temporal.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SUNDAY.getValue()) {
            temporal = temporal.plus(1, ChronoUnit.DAYS);
        }
        return temporal;
    }
}

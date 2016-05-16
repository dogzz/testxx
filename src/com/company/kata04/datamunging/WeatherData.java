/*
* Copyright Medtronic, Inc. 2014-2015
*
* MEDTRONIC CONFIDENTIAL - This document is the property of Medtronic,
* Inc.,and must be accounted for. Information herein is confidential. Do
* not reproduce it, reveal it to unauthorized persons, or send it outside
* Medtronic without proper authorization.
*/

package com.company.kata04.datamunging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class WeatherData extends ProcessingData {

    public WeatherData() {
        super("resources\\weather.dat");
    }

    public int getSpreadForDay(int day) {
        return getMaxTempForDay(day) - getMinTempForDay(day);
    }

    public int getMaxTempForDay(int day) {
        return getIntParamForFilterParam("Dy", String.valueOf(day), "MxT");
    }

    public int getMinTempForDay(int day) {
        return getIntParamForFilterParam("Dy", String.valueOf(day), "MnT");
    }

    public String getDayWithSmallestSpread() {
        List<Integer> spreads = new ArrayList<>();
        List<String> days = getAllValuesByName("Dy");
        spreads.addAll(days.stream().map(day -> getSpreadForDay(Integer.valueOf(day))).collect(Collectors.toList()));
        int minSpreadIndex = getMinSpreadIndex(spreads);
        return days.get(minSpreadIndex);
    }
}

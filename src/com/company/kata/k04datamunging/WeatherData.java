package com.company.kata.k04datamunging;

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

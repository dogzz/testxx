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

public class WeatherData {

    File fileSource;
    FileReader reader;
    List<Map<String, String>> rawData;

    List<String> headers = new ArrayList<>();

    public WeatherData() {
        fileSource = new File("resources\\weather.dat");
        try {
            reader = new FileReader(fileSource);
            rawData = generateRawData(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Map<String, String>> generateRawData(FileReader reader) {
        List<Map<String, String>> data = new ArrayList<>();
        new BufferedReader(reader).lines().forEachOrdered(s -> {
            if (headers.isEmpty()) {
                headers = getHeadersList(s);
            } else if (!s.isEmpty()) {
                data.add(getRowMap(s));
            }
        });
        return data;
    }

    private List<String> getHeadersList(String sourceString) {
        String[] temp = sourceString.split("\\s+");
        List<String> resultList = new ArrayList<>();
        for (String s : temp) {
            if (!s.isEmpty()) resultList.add(s);
        }
        return resultList;
    }

    private Map<String, String> getRowMap(String sourceString) {
        List<String> tempWithoutEmptyStrings = Arrays.asList(sourceString.split("\\s+")).stream()
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toList());
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < tempWithoutEmptyStrings.size(); i++) {
            map.put(headers.get(i), tempWithoutEmptyStrings.get(i));
        }
        return map;
    }

    public FileReader getReader() {
        return reader;
    }

    public List<Map<String, String>> getRawData() {
        return rawData;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public int getSpreadForDay(int day) {
        return getMaxTempForDay(day) - getMinTempForDay(day);
    }

    public int getMaxTempForDay(int day) {
        return getIntParamForFilterParamDay("Dy", String.valueOf(day), "MxT");
    }

    public int getMinTempForDay(int day) {
        return getIntParamForFilterParamDay("Dy", String.valueOf(day), "MnT");
    }

    private int getIntParamForFilterParamDay(String filterParamName, String filterParamValue, String paramName) {
        for (Map<String, String> map : rawData) {
            if (map.get(filterParamName).equals(filterParamValue)) {
                try {
                    return Integer.valueOf(map.get(paramName));
                } catch (NumberFormatException ex) {
                    return Integer.valueOf(map.get(paramName).substring(0, map.get(paramName).length() - 1));
                }
            }
        }
        return -1;
    }

    public String getDayWithSmallestSpread() {
        List<Integer> spreads = new ArrayList<>();
        List<String> days = getAllValuesByName("Dy");
        spreads.addAll(days.stream().map(day -> getSpreadForDay(Integer.valueOf(day))).collect(Collectors.toList()));
        int minSpreadIndex = 0;
        for (int i = 1; i < spreads.size(); i++) {
            if (spreads.get(i) < spreads.get(minSpreadIndex)) {
                minSpreadIndex = i;
            }
        }
        return days.get(minSpreadIndex);
    }

    private List<String> getAllValuesByName(String paramName) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rawData.size(); i++) {
            result.add(rawData.get(i).get(paramName));
        }
        return result;
    }
}

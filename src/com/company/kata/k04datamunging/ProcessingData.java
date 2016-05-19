package com.company.kata.k04datamunging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class ProcessingData {

    protected File fileSource;
    protected FileReader reader;
    protected List<Map<String, String>> rawData;

    List<String> headers = new ArrayList<>();

    protected ProcessingData(String dataFileName) {
        fileSource = new File(dataFileName);
        try {
            reader = new FileReader(fileSource);
            rawData = generateRawData(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected List<Map<String, String>> generateRawData(FileReader reader) {
        List<Map<String, String>> data = new ArrayList<>();
        new BufferedReader(reader).lines().forEachOrdered(s -> {
            if (headers.isEmpty()) {
                headers = getHeadersList(s);
            } else if (!s.isEmpty() && !s.contains("--------")) {
                data.add(getRowMap(s));
            }
        });
        return data;
    }

    protected List<String> getHeadersList(String sourceString) {
        String[] temp = sourceString.split("\\s+");
        List<String> resultList = new ArrayList<>();
        for (String s : temp) {
            if (!s.isEmpty()) resultList.add(s);
        }
        return resultList;
    }

    private Map<String, String> getRowMap(String sourceString) {
        List<String> tempWithoutEmptyStrings = Arrays.asList(sourceString.split("\\s+")).stream()
                .filter(line -> !line.isEmpty() && !line.equals("-"))
                .collect(Collectors.toList());
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < tempWithoutEmptyStrings.size(); i++) {
            map.put(headers.get(i), tempWithoutEmptyStrings.get(i));
        }
        return map;
    }

    protected int getIntParamForFilterParam(String filterParamName, String filterParamValue, String paramName) {
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

    protected List<String> getAllValuesByName(String paramName) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rawData.size(); i++) {
            result.add(rawData.get(i).get(paramName));
        }
        return result;
    }

    protected int getMinSpreadIndex(List<Integer> spreads) {
        int minSpreadIndex = 0;
        for (int i = 1; i < spreads.size(); i++) {
            if (spreads.get(i) < spreads.get(minSpreadIndex)) {
                minSpreadIndex = i;
            }
        }
        return minSpreadIndex;
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
}

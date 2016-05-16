/*
* Copyright Medtronic, Inc. 2014-2015
*
* MEDTRONIC CONFIDENTIAL - This document is the property of Medtronic,
* Inc.,and must be accounted for. Information herein is confidential. Do
* not reproduce it, reveal it to unauthorized persons, or send it outside
* Medtronic without proper authorization.
*/

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryChop3 {

    static List<Integer> sourceIndexes;

    public static int chop(int searchFor, int[] searchSource) {
        if (searchSource.length == 0) {
            return -1;
        }
        sourceIndexes = createSourceIndexes(searchSource);
        int[] tempSource = Arrays.copyOf(searchSource, searchSource.length);
        while (true) {
            int mediumIndex = tempSource.length / 2;
            if (tempSource[mediumIndex] == searchFor) return sourceIndexes.get(mediumIndex);
            if (mediumIndex == 0 || mediumIndex >= tempSource.length) return -1;
            tempSource = getNewSlice(tempSource, tempSource[mediumIndex] > searchFor);
        }
    }

    private static int[] getNewSlice(int[] tempSource, boolean isDecrease) {
        if (isDecrease) {
            sourceIndexes = sourceIndexes.subList(0, tempSource.length / 2);
            return Arrays.copyOfRange(tempSource, 0, tempSource.length / 2);
        } else {
            sourceIndexes = sourceIndexes.subList(tempSource.length / 2, tempSource.length);
            return Arrays.copyOfRange(tempSource, tempSource.length / 2, tempSource.length);
        }
    }

    private static List<Integer> createSourceIndexes(int[] searchSource) {
        List<Integer> sourceIndexes = new ArrayList<>();
        for (int i = 0; i < searchSource.length; i++) {
            sourceIndexes.add(i);
        }
        return sourceIndexes;
    }
}

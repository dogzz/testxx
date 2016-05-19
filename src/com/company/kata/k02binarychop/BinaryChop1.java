package com.company.kata.k02binarychop;

import java.util.ArrayList;
import java.util.List;

public class BinaryChop1 {
    public static int chop(int searchFor, int[] searchSource) {
        if (searchSource.length == 0) {
            return -1;
        }
        int mediumIndex = searchSource.length / 2;
        List<Integer> usedIndexes = new ArrayList<>();
        while (true) {
            if (searchSource[mediumIndex] == searchFor) {
                return mediumIndex;
            } else if (mediumIndex == 0 || mediumIndex == searchSource.length - 1) {
                return -1;
            }
            usedIndexes.add(mediumIndex);
            mediumIndex = getMediumIndex(searchSource[mediumIndex] > searchFor, mediumIndex);
            if (usedIndexes.contains(mediumIndex)) {
                return -1;
            }
        }
    }

    private static int getMediumIndex(boolean isIndexToBeDecreased, int currentIndex) {
        if (isIndexToBeDecreased) {
            return currentIndex - getOffset(currentIndex);
        } else {
            return currentIndex + getOffset(currentIndex);
        }
    }

    private static int getOffset(int currentIndex) {
        return currentIndex / 2 == 0 ? 1 : currentIndex / 2;
    }
}

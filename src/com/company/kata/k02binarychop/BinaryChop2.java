package com.company.kata.k02binarychop;

import java.util.ArrayList;
import java.util.List;

public class BinaryChop2 {

    private static List<Integer> usedIndexes;

    public static int chop(int searchFor, int[] searchSource) {
        if (searchSource.length == 0) {
            return -1;
        }
        usedIndexes = new ArrayList<>();
        int mediumIndex = searchSource.length / 2;
        return getIndexForElement(searchFor, searchSource, mediumIndex);
    }

    private static int getIndexForElement(int element, int[] searchSource, int mediumIndex) {
        if (searchSource[mediumIndex] == element) return mediumIndex;
        if (mediumIndex == 0 || mediumIndex == searchSource.length - 1) return -1;
        usedIndexes.add(mediumIndex);
        mediumIndex = getMediumIndex(searchSource[mediumIndex] > element, mediumIndex);
        if (usedIndexes.contains(mediumIndex)) return -1;
        return getIndexForElement(element, searchSource, mediumIndex);
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

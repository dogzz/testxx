/*
* @Author: dogzz
* @Created: 7/11/2016
*/

package com.company.kata.k13countingcodelines;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeLinesCounter {

    public int getLinesOfCode(String code) {
        String commentsCleared = clearComments(code);
        List<String> lines = Arrays.asList(commentsCleared.split("\n"));

        return clearEmptyString(lines).size();
    }

    private List<String> clearEmptyString(List<String> lines) {
        return lines.stream().filter(s -> {
            String processsed = s.replaceAll("\\s", "");
            return !processsed.isEmpty();
        }).collect(Collectors.toList());
    }

    private String clearComments(String code) {
        String multiLineCommnets = code.replaceAll("(?s)(?m)/\\*.*?\\*/", "");
        String singleLineComments = multiLineCommnets.replaceAll("(?s)(?m)//.*?$", "");
        return singleLineComments;
    }
}

/*
* @Author: dogzz
* @Created: 5/26/2016
*/

package com.company.kata.k11sortingout;

import com.company.kata.k02binarychop.BinaryChop2;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private List<Integer> balls = new ArrayList<>();

    public void addBall(int ballNumber) {
        if (balls.isEmpty()) {
            balls.add(ballNumber);
        } else {
            int index = getIndexToAdd(ballNumber);
            balls.add(index, ballNumber);
        }
    }

    private int getIndexToAdd(int ballNumber) {
        int index = balls.indexOf(ballNumber);
        if (index != -1) return index;
        for (int i = 0; i < balls.size() - 1; i++) {
            if (balls.get(i) < ballNumber && balls.get(i + 1) > ballNumber) return i + 1;
        }
        return balls.get(balls.size() - 1) < ballNumber ? balls.size() : 0;
    }

    public List<Integer> getBalls() {
        return balls;
    }
}

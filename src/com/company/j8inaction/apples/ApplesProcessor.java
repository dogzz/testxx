/*
* @Author: dogzz
* @Created: 5/24/2016
*/

package com.company.j8inaction.apples;

import java.util.List;

public class ApplesProcessor {

    public String getApplesWithFormat(List<Apple> inventory, AppleFormatter formatter) {
        String result = "";
        for (Apple apple : inventory) {
           result += formatter.accept(apple) + " ";
        }
        return result;
    }
}

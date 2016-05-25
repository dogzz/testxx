/*
* @Author: dogzz
* @Created: 5/24/2016
*/

package com.company.j8inaction.apples;

public class WeightClassAppleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String result = "";
        result += apple.getColor() + " " + apple.getWeight() + "g => ";
        result += apple.getWeight() > 150 ? "Heavy" : "Light";
        return result;
    }
}

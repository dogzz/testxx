/*
* @Author: dogzz
* @Created: 5/24/2016
*/

package com.company.j8inaction.apples;

public class WeightAppleFormatter implements AppleFormatter{

    @Override
    public String accept(Apple apple) {
        return String.valueOf(apple.getWeight());
    }
}

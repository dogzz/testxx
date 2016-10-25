/*
* @Author: dogzz
* @Created: 9/19/2016
*/

package com.company.coreimpatient.chapter3oop;

public class MegaCar extends Car {

    Integer tst = 10;

    public MegaCar(double efficiency) {
        super(efficiency);
    }

    public void printResult() {
        System.out.println(getResult());
    }

    @Override
    public int getResult() {
        return tst+1;
    }
}

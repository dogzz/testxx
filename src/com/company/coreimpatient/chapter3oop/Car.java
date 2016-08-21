package com.company.coreimpatient.chapter3oop;

/**
 * Created by afon on 21.08.2016.
 */
public class Car {
    private double efficiency;
    private final double origin;
    private double currentPosition = 0;
    private double gas = 0;


    public Car(double efficiency) {
        this.efficiency = efficiency;
        this.origin = 0;
    }

    public void drive(double miles) {
        currentPosition +=miles;
        gas = gas - miles / efficiency;
    }

    public void addGas(double gallons) {
        gas += gallons;
    }

    public double getCurrentDistance() {
        return currentPosition - origin;
    }

    public double getGas() {
        return gas;
    }
}

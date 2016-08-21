package com.company.coreimpatient.chapter3oop;

/**
 * Implement	an	immutable	class	Point	that	describes	a	point	in	the	plane.
 * Created by afon on 21.08.2016.
 */
public class ImPoint {
    private double x;
    private double y;

    public ImPoint(){
        x = 0;
        y = 0;
    }

    public ImPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ImPoint translate(int moveByX, int moveByY) {
        x = x + moveByX;
        y = y + moveByY;
        return this;
    }

    public ImPoint scale(double factor) {
        x = (x*factor);
        y = (y*factor);
        return this;
    }
}

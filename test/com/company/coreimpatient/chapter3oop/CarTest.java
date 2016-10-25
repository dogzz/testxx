package com.company.coreimpatient.chapter3oop;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by afon on 21.08.2016.
 */
public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new MegaCar(20);
        car.addGas(50);
    }

    @Test
    public void driveCheckGas() {
        car.drive(40);
        assertThat(car.getGas(), is(48.0));
        car.drive(20);
        assertThat(car.getGas(), is(47.0));
    }

    @Test
    public void driveCheckDistance() {
        car.drive(20);
        assertThat(car.getCurrentDistance(), is(20.0));
        car.drive(60);
        assertThat(car.getCurrentDistance(), is(80.0));
    }

    @Test
    public void driveAddGas() {
        assertThat(car.getGas(), is(50.0));
        car.drive(40);
        car.addGas(30);
        assertThat(car.getGas(), is(78.0));
    }

}
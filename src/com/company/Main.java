package com.company;

import com.company.coreimpatient.chapter3oop.Car;
import com.company.coreimpatient.chapter3oop.MegaCar;
import com.company.j8inaction.apples.Apple;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    String prop;


    public static void main(String[] args) {

        System.out.println("sdsd");
        A a = new A();
        B b = new B();
//        a.prn();
        b.prn();
        a = b;
//        a.prn();
        a.prn1();
//        a.prn2();
        D d = a;
        D.prn2();
        System.out.println(String.format("Factorial is %.0f", a.fact(-1f)));
        Car mCar = new MegaCar(45.1);
        mCar.printResult();


    }

    public void someMethod(int param1, String param2) {
        Supplier<String> c1 = String::new;
        String a1 = c1.get();
        BiFunction<String, Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply("green", 110);
        int i = 1;
        Predicate<String> c = s -> {
            System.out.println(prop);
            return true;
        };
        i = 2;
        prop = "2";
    }



    static class A implements C, D{

        public Float fact(Float x) {
            if (x > 1) {
                return x * fact(x - 1);
            }
            return 1f;
        }

//        static public void prn2() {
//            System.out.println("I am A");
//        }
    }

    static class B extends A {
        public void prn() {
            System.out.println("I am B" + i);
        }

    }

    interface C {
        int i = 0;
        default void prn1() {
            System.out.println("I am default method");
        }
//        void prn();
    }

    interface D {
        static void prn2() {
            System.out.println("I am second default method");
        }
    }
}

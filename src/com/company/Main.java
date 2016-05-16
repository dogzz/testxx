package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

public class Main {


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

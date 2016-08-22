/*
* @Author: dogzz
* @Created: 8/22/2016
*/

package com.company.coreimpatient.chapter4reflection;

public class FactStackTrace {
    public static void main(String...args) {
        System.out.println(fact(4));
    }

    public static int fact(int n) {
        Exception ex = new Exception();
        System.out.println("Value: " + n);
        ex.printStackTrace();
        if (n == 0) return 1;
        if (n > 1) {
            return n*fact(n - 1);
        } else {
            return 1;
        }
    }
}

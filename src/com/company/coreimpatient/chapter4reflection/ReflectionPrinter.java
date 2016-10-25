package com.company.coreimpatient.chapter4reflection;

import com.company.coreimpatient.chapter3oop.Car;
import com.company.coreimpatient.chapter3oop.MegaCar;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.DoubleFunction;

/**
 * Created by afon on 21.08.2016.
 */
public class ReflectionPrinter {
    public static void main(String...args) throws Exception {
        ReflectionPrinter rp = new ReflectionPrinter();
        Car car = new MegaCar(20);

        System.out.println(rp.reflectionToString(car));
        rp.printMethods("[I");
        rp.helloWorld();
        Method method = Double.class.getMethod("toHexString", double.class);
        rp.printValues(method, 4, 9, 1);
        rp.printValues(i -> {
            try {
                return method.invoke(method.getClass(), i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }, 4, 9, 1);
        rp.printValues(Math::sqrt, 4, 9, 1);

    }

    public String reflectionToString(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        return Arrays.toString(fields);
    }

    public void printMethods(String className) throws Exception {
        Class<?> cl = Class.forName(className);
        while	(cl	!=	null)	{
            for	(Method m	:	cl.getDeclaredMethods())	{
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " "	+
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName() +
                        Arrays.toString(m.getParameters()));
            }
            cl	=	cl.getSuperclass();
        }
    }

    public void helloWorld() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = System.out.getClass();
        Method met = cls.getMethod("println", String.class);
        met.invoke(System.out, "Hello World");
    }

    public void printValues(Method method, double start, double end, double step) throws InvocationTargetException, IllegalAccessException {
        for (double i = start; i <= end; i += step) {
            System.out.println(method.invoke(method.getClass(), i));
        }
    }

    public void printValues(DoubleFunction<Object> func, double start, double end, double step) throws InvocationTargetException, IllegalAccessException {
        for (double i = start; i <= end; i += step) {
            System.out.println(func.apply(i));
        }
    }
}

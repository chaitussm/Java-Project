package com.advanced.garbageCollection;
import java.util.Date;

public class runtimeDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Max Memory: " + runtime.maxMemory());
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());

        for (int i = 0; i < 10000 ; i++) {

            Date d = new Date();
            d = null;

        }

        System.out.println("Before GC - Max Memory: " + runtime.maxMemory());
        System.out.println("Before GC - Total Memory: " + runtime.totalMemory());
        System.out.println("Before GC - Free Memory: " + runtime.freeMemory());

        runtime.gc();

        System.out.println("After GC - Max Memory: " + runtime.maxMemory());
        System.out.println("After GC - Total Memory: " + runtime.totalMemory());
        System.out.println("After GC - Free Memory: " + runtime.freeMemory());
    }
}
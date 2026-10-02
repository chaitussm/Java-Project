package com.exceptionHandling;

public class RethrowingExceptions {

    /*Here we are demonstrating rethrowing exceptions */
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
        } catch (Exception e) {
            //throw NullPointerException;
        }
    }
    
}

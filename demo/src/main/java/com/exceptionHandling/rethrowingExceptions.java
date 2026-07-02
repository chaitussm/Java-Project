package com.exceptionHandling;

public class rethrowingExceptions {

    /*Here we are demonstrating rethrowing exceptions */
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
        } catch (Exception e) {
            //throw nullPointerException;
        }
    }
    
}

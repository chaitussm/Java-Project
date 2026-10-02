package com.exceptionHandling;

public class nullPointerException {

    /*In the below example the defalut value for the static variable is null
    thsts why we will get null pointer exception*/

    static ArithmeticException e;
    public static void main(String[] args) {
       
        throw e ;
    }
    
}

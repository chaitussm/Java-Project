package com.exceptionHandling;

/*
finally block is always associated with after try catch block to maintain clean up code

*/
class finallyBlock {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } finally {
            System.out.println("This block is always executed.");
        }
    }
}
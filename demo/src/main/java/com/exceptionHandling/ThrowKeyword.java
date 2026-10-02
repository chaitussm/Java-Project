package com.exceptionHandling;

public class throwKeyword {
    public static void main(String[] args) {

        /*Example 1*/
    System.out.println(10/0);
       /*Example 2*/ 
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

         /*Example 3*/
    throw new ArithmeticException("/ by zero");
     /*For 1 and 3 same output we will get*/
    }

    static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be at least 18.");
        } else {
            System.out.println("Access granted.");
        }
    }

   
}

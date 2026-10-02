package com.exceptionHandling;

public class tryCatchBasics {
    /*It is highly recommenede to use try catch block in the bleow format 
       try{
           //code that may throw exception or risky code
        {
           catch(Exception e){
            //code to handle exception
        }
    */
    public static void main(String[] args) {
        try {
            sayHi();
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }

    public static void sayHi() {
        System.out.println("Hi");
        sayHello();
    }

    public static void sayHello() {
        System.out.println("Hello");
    }
    
}

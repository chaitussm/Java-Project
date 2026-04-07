package com.Operators_Assignments;

public class InstanceOfOperator {
    //Understand the concept of instanceof operator in Java
    //The instanceof operator is used to test whether an object is an instance of a specific class or 
    // implements a specific interface. It returns true if the object is an instance of the specified type, and false otherwise.
    public static void main(String[] args) {
        String str = "Hello";
        Integer num = 10;

        System.out.println("str instanceof String: " + (str instanceof String)); // Output: true
        System.out.println("num instanceof Integer: " + (num instanceof Integer)); // Output: true
        System.out.println("str instanceof Object: " + (str instanceof Object)); // Output: true
        System.out.println("num instanceof Object: " + (num instanceof Object)); // Output: true
        //System.out.println("str instanceof Integer: " + (str instanceof Integer)); 
        // Output: false beacuse str is not an instance of Integer class, it is an instance of String class. 
        // Therefore, the instanceof operator returns false when checking if str is an instance of Integer.
        //System.out.println("num instanceof String: " + (num instanceof String)); 
        // Output: false beacuse num is not an instance of String class, it is an instance of Integer class.
        // Therefore, the instanceof operator returns false when checking if num is an instance of String.

         //case 1: Using instanceof with null

        // Important points to remember:
        // 1. The instanceof operator can only be used with reference types (classes and interfaces). It cannot be used with primitive data types.
        // 2. If the left operand is null, the result of the instanceof operator will always be false, regardless of the type being checked against.
    }
    
}

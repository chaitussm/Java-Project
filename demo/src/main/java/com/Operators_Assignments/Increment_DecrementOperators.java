package com.Operators_Assignments;

public class Increment_DecrementOperators {
    //Understand the concept of increment and decrement operators in Java
    //Increment operator (++) increases the value of a variable by 1
    //Decrement operator (--) decreases the value of a variable by 1
    //Increment consits of two types: pre-increment and post-increment
    //Pre-increment: the variable is incremented before it is used in an expression
    //Post-increment: the variable is used in an expression before it is incremented
    //Decrement also consists of two types: pre-decrement and post-decrement
    //Pre-decrement: the variable is decremented before it is used in an expression
    //Post-decrement: the variable is used in an expression before it is decremented
    public static void main(String[] args) {
        int a = 5;
        System.out.println("Initial value of a: " + a); // Output: 5

        // Pre-increment
        System.out.println("Pre-increment: " + (++a)); // Output: 6
        System.out.println("Value of a after pre-increment: " + a); // Output: 6

        // Post-increment
        System.out.println("Post-increment: " + (a++)); // Output: 6
        System.out.println("Value of a after post-increment: " + a); // Output: 7

        // Pre-decrement
        System.out.println("Pre-decrement: " + (--a)); // Output: 6
        System.out.println("Value of a after pre-decrement: " + a); // Output: 6

        // Post-decrement
        System.out.println("Post-decrement: " + (a--)); // Output: 6
        System.out.println("Value of a after post-decrement: " + a); // Output: 5

        // Important points to remember:
        // 1. Increment and decrement operators can only be used with numeric data types and primitive datatypes (byte, short, int, long, float, double) and char data type.
        // 2. They cannot be used with boolean or String data types.

        //case 1 : We cannot use increment or decrement operator with boolean data type
        //boolean b = true;
        //b++; // This will cause a compilation error
        //case 2: We cannot use increment or decrement operator with String data type
        //String str = "Hello";
        //str++; // This will cause a compilation error
        //case 3: We cannot use increment or decrement operator with char data type
        //char c = 'A';
        //c++; // This will cause a compilation error
        
    }
    
}

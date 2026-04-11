package com.fundamentals.operators;

public class BooleanComplementOperator {
    //Understand the concept of boolean complement operator in Java
    //The boolean complement operator (!) is a unary operator that negates the value of a boolean expression. 
    // It changes true to false and false to true.
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println("Boolean complement of " + a + " is: " + !a); // Output: false
        System.out.println("Boolean complement of " + b + " is: " + !b); // Output: true
        System.out.println("Boolean complement of (a && b) is: " + !(a && b)); // Output: true
        System.out.println("Boolean complement of (a || b) is: " + !(a || b)); // Output: false
        System.out.println("Boolean complement of (a ^ b) is: " + !(b ^ a)); 
        // Output: false because the boolean complement operator negates the result of the exclusive OR (XOR) operation between a and b. 
        // The XOR operation returns true if exactly one of the operands is true, and false otherwise. 
        // Since a is true and b is false, the XOR operation (b ^ a) returns true. 
        // Therefore, the boolean complement operator negates this result and returns false

        // Important points to remember:
        // 1. The boolean complement operator can only be used with boolean data types. It cannot be used with other data types.
        // 2. The result of applying the boolean complement operator to a boolean expression will always be the opposite of the original value.
    }
    
}

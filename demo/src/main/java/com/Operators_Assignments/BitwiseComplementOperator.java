package com.Operators_Assignments;

public class BitwiseComplementOperator {
    //Understand the concept of bitwise complement operator in Java
    //The bitwise complement operator (~) is a unary operator that inverts the bits of its operand. 
    // It changes each 0 to 1 and each 1 to 0 in the binary representation of the operand.
    public static void main(String[] args) {
        int a = 5; // In binary: 0000 0101
        int result = ~a; // In binary: 1111 1010 (which is -6 in decimal)
        System.out.println("Bitwise complement of " + a + " is: " + result); // Output: -6

        // Important points to remember:
        // 1. The bitwise complement operator can only be used with integer data types (byte, short, int, long).
        // 2. The result of applying the bitwise complement operator to an integer will be a negative number due to how negative numbers are represented in binary (two's complement).
    }
    
}

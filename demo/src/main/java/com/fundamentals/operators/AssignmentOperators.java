package com.fundamentals.operators;

public class AssignmentOperators {

    //Understand the concept of assignment operators in Java
    //Assignment operators are used to assign values to variables. The most basic assignment operator is the equals sign (=), which assigns the value on the right to the variable on the left.
    public static void main(String[] args) {
        int a = 10; // Using the basic assignment operator to assign the value 10 to variable a
        System.out.println("Value of a: " + a); // Output: Value of a: 10

        // Compound assignment operators combine an arithmetic operation with assignment. For example, += adds the right operand to the left operand and assigns the result back to the left operand.
        a += 5; // This is equivalent to a = a + 5
        System.out.println("Value of a after += 5: " + a); // Output: Value of a after += 5: 15

        // Other compound assignment operators include -=, *=, /=, and %=, which perform subtraction, multiplication, division, and modulus operations respectively before assigning the result back to the variable.

        // Important points to remember:
        // 1. Assignment operators can be used with various data types, including primitive types and reference types.
        // 2. Compound assignment operators can help simplify code by combining an operation with assignment, 
        // but they should be used carefully to avoid confusion or unintended side effects.
        // example byte b = 10;
        // b = = b +1 // This will cause a compilation error 
        // because the left-hand side of the assignment operator cannot be an expression.
        //NOTE always addition means max(int, type of variable a , type of variable b) and subtraction means max(int, type of variable a , type of variable b) and multiplication means max(int, type of variable a , type of variable b) and division means max(int, type of variable a , type of variable b) and modulus means max(int, type of variable a , type of variable b   )
    }
    
}

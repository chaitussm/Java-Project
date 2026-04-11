package com.fundamentals.operators;

public class ShortCircuitOperators {
    //Understand the concept of short-circuit operators in Java
    //Short-circuit operators are logical operators that evaluate their operands from left to right and stop evaluating as soon as the result is determined. 
    // In Java, the short-circuit operators are && (logical AND) and || (logical OR).
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        // Using short-circuit AND operator (&&)
        boolean result1 = (a > b) && (b > 0); // The first condition (a > b) is false, so the second condition is not evaluated
        System.out.println("Result of short-circuit AND: " + result1); // Output: false

        // Using short-circuit OR operator (||)
        boolean result2 = (a < b) || (b < 0); // The first condition (a < b) is true, so the second condition is not evaluated
        System.out.println("Result of short-circuit OR: " + result2); // Output: true

        // Important points to remember:
        // 1. Short-circuit operators can improve performance by avoiding unnecessary evaluations of expressions.
        // 2. When using short-circuit operators, be cautious of side effects in the expressions being evaluated, as they may not be executed if the evaluation stops early.
    }
    
}

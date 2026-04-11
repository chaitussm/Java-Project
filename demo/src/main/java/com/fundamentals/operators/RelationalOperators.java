package com.fundamentals.operators;

public class RelationalOperators {
    //Understand the concept of relational operators in Java
    //Relational operators are used to compare two values and return a boolean result (true or false). They are commonly used in conditional statements and loops to control the flow of the program based on certain conditions.
    //The relational operators in Java are:
    //1. Equal to (==): Returns true if the operands are equal
    //2. Not equal to (!=): Returns true if the operands are not equal
    //3. Greater than (>): Returns true if the left operand is greater than the right operand
    //4. Less than (<): Returns true if the left operand is less than the right operand
    //5. Greater than or equal to (>=): Returns true if the left operand is greater than or equal to the right operand
    //6. Less than or equal to (<=): Returns true if the left operand is less than or equal to the right operand

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("a == b: " + (a == b)); // Output: false
        System.out.println("a != b: " + (a != b)); // Output: true
        System.out.println("a > b: " + (a > b)); // Output: true
        System.out.println("a < b: " + (a < b)); // Output: false
        System.out.println("a >= b: " + (a >= b)); // Output: true
        System.out.println("a <= b: " + (a <= b)); // Output: false

        //Nesting of relatioal operators is not allowed in Java. For example, the following code will cause a compilation error:`   
        //if (a > b > 0) { // This will cause a compilation error beacuse the 
        // result of a > b is a boolean value, and we cannot compare a boolean value with an integer (0 in this case).
        // Important points to remember:
        // 1. Relational operators can be used with numeric data types (byte, short, int, long, float, double) and char data type.
        // 2. They cannot be used with boolean or String data types.
        // 3. When comparing floating-point numbers, it is important to consider precision issues, as they may not always yield expected results due to how they are represented in memory.
    }
    
}

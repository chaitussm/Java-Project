package com.fundamentals.operators;

public class ConditionalOperator {
    //Understand the concept of conditional operator in Java
    //The conditional operator (also known as the ternary operator) is a shorthand way of writing an if-else statement. 
    // It takes three operands: a condition, a value to return if the condition is true, and a value to return if the condition is false. 
    // The syntax for the conditional operator is: condition ? value_if_true : value_if_false;
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Using the conditional operator to find the maximum of two numbers
        int max = (a > b) ? a : b; // If a is greater than b, return a; otherwise, return b
        System.out.println("The maximum of " + a + " and " + b + " is: " + max); // Output: 20

        // Using the conditional operator to check if a number is even or odd
        int num = 15;
        String result = (num % 2 == 0) ? "Even" : "Odd"; // If num is divisible by 2, return "Even"; otherwise, return "Odd"
        System.out.println(num + " is an " + result); // Output: 15 is an Odd

        // Important points to remember:
        // 1. The conditional operator is a concise way to write simple if-else statements, but it should be used judiciously for readability.
        // 2. The condition in the conditional operator must evaluate to a boolean value (true or false). If the condition is not a boolean expression, it will result in a compilation error.
        // ? true : means if the condition is true, return the value before the colon (:), otherwise return the value after the colon (:).
}   

}

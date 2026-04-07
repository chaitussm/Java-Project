package com.Operators_Assignments;

public class ArithmeticOperators {
    
    //Understand the concept of arithmetic operators in Java
    //Arithmetic operators are used to perform basic mathematical operations on numeric data types (byte, short, int, long, float, double) and char data type.
    //The arithmetic operators in Java are:
    //1. Addition (+): Adds two operands
    //2. Subtraction (-): Subtracts the second operand from the first operand
    //3. Multiplication (*): Multiplies two operands
    //4. Division (/): Divides the first operand by the second operand
    //5. Modulus (%): Returns the remainder of the division of the first operand by the second operand
    //6. NAN (Not a Number): Represents an undefined or unrepresentable value, such as the result of dividing zero by zero or taking the square root of a negative number.

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("Addition: " + (a + b)); // Output: 15
        System.out.println("Subtraction: " + (a - b)); // Output: 5
        System.out.println("Multiplication: " + (a * b)); // Output: 50
        System.out.println("Division: " + (a / b)); // Output: 2
        System.out.println("Modulus: " + (a % b)); // Output: 0

        // Important points to remember:
        // 1. When performing division with integers, the result will be an integer (the fractional part will be discarded). To get a floating-point result, at least one of the operands must be a floating-point number.
        System.out.println("Division with floating-point result: " + (a / (double) b)); // Output: 2.0

        // 2. The modulus operator can be used to determine if a number is even or odd. If a number is even, it will have a modulus of 0 when divided by 2; if it is odd, it will have a modulus of 1.
        int num = 7;
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

        //3.example of NAN (Not a Number)
        double result = 0.0 / 0.0; // This will result in NAN
        System.out.println("Result of 0.0 / 0.0: " + result); // Output: NAN    
    }

    //Important points to remember:
    //1. It is run-time execption but not compile-time error when we divide a number by zero. It will throw an ArithmeticException at runtime.
    //2. The modulus operator can be used to determine if a number is even or odd. If a number is even, it will have a modulus of 0 when divided by 2
    //It is possible only in integral data types (byte, short, int, long) and char data type. 
    // It cannot be used with floating-point data types (float, double) because they can represent a wider range of values, including very small and very large numbers, as well as special values like NAN and infinity.
    //3. the only operatots whgich can cause arithmetic exception is division operator (/) when we divide a 
    // number by zero. The modulus operator (%) will not throw an exception when we divide a number by zero, but it will return a result of NAN (Not a Number) for floating-point data types and 0 for integral data types.
}

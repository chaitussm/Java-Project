package com.Operators_Assignments;

public class StringConcatenationOperators {
    //Understand the concept of string concatenation operators in Java
    //String concatenation is the process of combining two or more strings into a single string. In Java, the string concatenation operator is the plus sign (+).
    //When the + operator is used with strings, it concatenates them together. If one of the operands is a string and the other is not, the non-string operand will be converted to a string before concatenation.
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String result = str1 + " " + str2; // Concatenating str1 and str2 with a space in between
        System.out.println(result); // Output: Hello World

        // Concatenating a string with a non-string operand
        int num = 10;
        String str3 = "The number is: " + num; // The integer num will be converted to a string before 
        // concatenation
        System.out.println(str3); // Output: The number is: 10

        // Important points to remember:
        // 1. The + operator can be used for both addition and string concatenation. The context in which it is used determines its behavior.
        // 2. When using the + operator for string concatenation, if any of the operands is a string, the other operand will be converted to a string before concatenation.
        // 3. String concatenation can also be achieved using the concat() method of the String class, but using the + operator is more common and often more convenient for simple concatenations.
    }
    
}

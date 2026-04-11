package com.fundamentals.operators;

public class TypeCasteOperators {

    //Understand the concept of type caste operators in Java
    //Type casting is the process of converting a variable from one data type to another. In Java, there are two types of type casting: 
    // 1. Implicit Casting (Widening) JVM will do it automatically when converting a smaller data type to a larger data type,
    // and 2. Explicit Casting (Narrowing). While doing this some bits of data may be lost, so the 
    // developer needs to specify the target data type when converting a larger data type to a smaller data type.
    public static void main(String[] args) {
        // Implicit Casting (Widening)
        int num = 10;
        double doubleNum = num; // Implicitly casting int to double
        System.out.println("Implicit Casting (Widening): " + doubleNum); // Output: 10.0

        // Explicit Casting (Narrowing)
        double pi = 3.14;
        short shortpi = (short) pi; // Explicitly casting double to short
        int intPi = (int) pi; 
        //Here the formula is (target data type) value to be cast, 
        // in this case we are casting the double value of pi to an int, which results in the loss of the decimal part and gives us 3 as the output.
        // Explicitly casting double to int
        System.out.println("Explicit Casting (Narrowing): " + intPi); // Output: 3
        System.out.println("Explicit Casting (Narrowing): " + shortpi); // Output: 3
        // Important points to remember:
        // 1. Implicit casting happens automatically when converting a smaller data type to a larger data type (e.g., int to double). It is safe and does not result in data loss.
        // 2. Explicit casting is required when converting a larger data type to a smaller data type (e.g., double to int). It can lead to data loss if the value being cast cannot be represented in the target data type.
        // 3. When performing explicit casting, you need to use parentheses to specify the target data type before the value being cast.
    }
    
}

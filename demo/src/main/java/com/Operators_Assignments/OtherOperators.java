package com.Operators_Assignments;

public class OtherOperators {
    //Understand the concept of other operators in Java
    //In addition to the basic arithmetic, relational, logical, and assignment operators, Java also provides several other operators that serve specific purposes. 
    // These include the string concatenation operator (+), the instanceof operator, the bitwise complement operator (~), and the boolean complement operator (!).
    public static void main(String[] args) {

        //[] operator helps create matrix 
        int[][] matrix = new int[3][3]; // Creates a 3x3 matrix (2D array) of integers
        System.out.println("Matrix created with dimensions: " + matrix.length + "x" + matrix[0].length); // Output: Matrix created with dimensions: 3x3
        //=============================================
        // difference between new and new instance 
        // new is a keyword in Java that is used to create an instance of a class, while newInstance() is a method of the Class class present in java.lang.class that can be used to create an instance of a class at runtime using reflection.
        // The new operator is used to create an instance of a class, while the newInstance() method is a reflection-based method that can be used to create an instance of a class at runtime. 
        // The new operator is typically used when you know the class you want to instantiate at compile time, while the newInstance() method is used when you want to create an instance of a class
        // new will work with any type of constructor while new instance will only work with no-argument constructor.
        // example 
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList"); // Load the ArrayList class
            Object instance = clazz.getDeclaredConstructor().newInstance(); // Create an instance of ArrayList using newInstance()
            System.out.println("Instance created using newInstance(): " + instance.getClass().getName()); // Output: Instance created using newInstance(): java.util.ArrayList
        } catch (Exception e) {
            e.printStackTrace();
        }
        //----------------------------------------------
        //difference bewteen instanceof vs isInstance
        // instanceof is a binary operator that checks if an object is an instance of a specific class or interface at compile time, while isInstance() is a method of the Class class i.e java.lang.class that can be used to check if an object is an instance of a specific class or interface at runtime.
        // The instanceof operator is used to check if an object is an instance of a specific class or interface at compile time, while the isInstance() method is a reflection-based method that can be
        // used to check if an object is an instance of a specific class or interface at runtime. The instanceof operator is typically used when you know the type you want to check against at compile time, while the isInstance() method is used when you want to perform the check dynamically at runtime.
        // example
        String str = "Hello";
        System.out.println("Using instanceof: " + (str instanceof String)); // Output: Using instanceof: true
        System.out.println("Using isInstance(): " + String.class.isInstance(str)); // Output: Using isInstance(): true
        //=============================================
        // The examples for these operators are provided in their respective classes: 
        // StringConcatenationOperators, InstanceOfOperator, BitwiseComplementOperator, and BooleanComplementOperator.
    }
    
}
package com.DataTypes;

public class FloatDataType {

    public static void floatdeclaration()
    {
         // Declare a float variable and assign a value
        float myFloat = 3.14f;

        // Print the value of the float variable
        System.out.println("The value of myFloat is: " + myFloat);

        // Demonstrating the range of float data type
        float minFloat = -3.4028235E38f; // Minimum value of float
        float maxFloat = 3.4028235E38f;  // Maximum value of float

        System.out.println("Minimum value of float: " + minFloat);
        System.out.println("Maximum value of float: " + maxFloat);

        //default value of float
        float defaultFloat = 0;
        System.out.println("Default value of float: " + defaultFloat);
    }

    public static void main(String[] args) 
    {
        floatdeclaration();
    }
    
}
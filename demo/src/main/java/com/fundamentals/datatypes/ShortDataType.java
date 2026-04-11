package com.fundamentals.datatypes;

public class ShortDataType {
    
    public static void shortdeclaration()
    {
         // Declare a short variable and assign a value
        short myShort = 10000;

        // Print the value of the short variable
        System.out.println("The value of myShort is: " + myShort);

        // Demonstrating the range of short data type
        short minShort = -32768; // Minimum value of short
        short maxShort = 32767;  // Maximum value of short

        System.out.println("Minimum value of short: " + minShort);
        System.out.println("Maximum value of short: " + maxShort);

        //default value of short
        short defaultShort = 0;
        System.out.println("Default value of short: " + defaultShort);
    }

    public static void main(String[] args) 
    {
        shortdeclaration();
    }
    
}

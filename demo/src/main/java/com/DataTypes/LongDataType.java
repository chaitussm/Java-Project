package com.DataTypes;

public class LongDataType {
    
    public static void longdeclaration()
    {
         // Declare a long variable and assign a value
        long myLong = 10000000000L;

        // Print the value of the long variable
        System.out.println("The value of myLong is: " + myLong);

        // Demonstrating the range of long data type
        long minLong = -9223372036854775808L; // Minimum value of long
        long maxLong = 9223372036854775807L;  // Maximum value of long

        System.out.println("Minimum value of long: " + minLong);
        System.out.println("Maximum value of long: " + maxLong);

        //default value of long
        long defaultLong = 0;
        System.out.println("Default value of long: " + defaultLong);
    }

    public static void main(String[] args) 
    {
        longdeclaration();
    }
}

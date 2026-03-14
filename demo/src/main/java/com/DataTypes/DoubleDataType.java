package com.DataTypes;

public class DoubleDataType {
    
    public static void doubledeclaration()
    {
         // Declare a double variable and assign a value
        double myDouble = 3.141592653589793;

        // Print the value of the double variable
        System.out.println("The value of myDouble is: " + myDouble);

        // Demonstrating the range of double data type
        double minDouble = -1.7976931348623157E308; // Minimum value of double
        double maxDouble = 1.7976931348623157E308;  // Maximum value of double

        System.out.println("Minimum value of double: " + minDouble);
        System.out.println("Maximum value of double: " + maxDouble);

        //default value of double
        double defaultDouble = 0;
        System.out.println("Default value of double: " + defaultDouble);
        
        //readability of double
        double largeDouble = 1.2_3;
        System.out.println("The value of largeDouble is: " + largeDouble);
    }

    public static void main(String[] args) 
    {
        doubledeclaration();
    }
}

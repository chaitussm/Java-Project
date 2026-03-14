package com.DataTypes;

public class IntdataType {
                                    
    public static void intdeclaration()
    {
         // Declare an int variable and assign a value
        int myInt = 100000;

        // Print the value of the int variable
        System.out.println("The value of myInt is: " + myInt);

        // Demonstrating the range of int data type
        int minInt = -2147483648; // Minimum value of int
        int maxInt = 2147483647;  // Maximum value of int

        System.out.println("Minimum value of int: " + minInt);
        System.out.println("Maximum value of int: " + maxInt);

        //default value of int
        int defaultInt = 0;
        System.out.println("Default value of int: " + defaultInt);
    }

    public static void main(String[] args) 
    {
        intdeclaration();
    }
}

package com.fundamentals.datatypes;

public class CharDataType {
    
    public static void chardeclaration()
    {
         // Declare a char variable and assign a value
        char myChar = 'A';

        // Print the value of the char variable
        System.out.println("The value of myChar is: " + myChar);

        // Demonstrating the range of char data type
        char minChar = '\u0000'; // Minimum value of char
        char maxChar = '\uffff';  // Maximum value of char

        System.out.println("Minimum value of char: " + (int)minChar);
        System.out.println("Maximum value of char: " + (int)maxChar);

        //default value of char
        char defaultChar = '\u0000';
        System.out.println("Default value of char: " + (int)defaultChar);
    }

    public static void main(String[] args) 
    {
        chardeclaration();
    }
}
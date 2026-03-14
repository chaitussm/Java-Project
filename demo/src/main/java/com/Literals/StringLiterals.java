package com.Literals;

public class StringLiterals {
    
    public static void stringliterals()
    {
        // String literals
        String greeting = "Hello, World!";
        String name = "Alice";
        String emptyString = ""; // Empty string literal

        System.out.println("Greeting: " + greeting);
        System.out.println("Name: " + name);
        System.out.println("Empty String: '" + emptyString + "'");

        // Demonstrating string concatenation
        String fullName = name + " Smith";
        System.out.println("Full Name: " + fullName);

        // Using escape sequences in string literals
        String escapedString = "This is a line break.\nThis is a tab:\tEnd of tab.";
        System.out.println("Escaped String:\n" + escapedString);
    }

    public static void charliterals()
    {
        // Character literals
        char letterA = 'A';
        char letterB = 'B';
        char digit1 = '1';
        char specialChar = '@';

        System.out.println("Character A: " + letterA);
        System.out.println("Character B: " + letterB);
        System.out.println("Digit 1: " + digit1);
        System.out.println("Special Character: " + specialChar);
    }
    
    public static void main(String[] args) {
        stringliterals();
        charliterals();
    }

}
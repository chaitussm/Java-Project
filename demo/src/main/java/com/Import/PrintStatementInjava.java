package com.Import;
import static java.lang.System.out;

public class PrintStatementInjava {
    //Understand the concept of print statement in Java
    //In Java, the print statement is used to display output on the console. 
    // The most commonly used print statements are System.out.print() and System.out.println().
    public static void main(String[] args) {
        // Example of print statement
        System.out.print("Hello, World!"); // Output: Hello, World!
        System.out.println("Welcome to Java programming."); // Output: Welcome to Java programming.
        System.out.println("This is a new line."); // Output: This is a new line.
        out.println(); // Using static import to print a new line without specifying System.out
        out.println("This is another line using static import."); // Output: This is another line
        // Important points to remember:
        //System is a class in the java.lang package, and out is a static member of the System class, which is an instance of the PrintStream class. It provides methods for printing various data types to the console.
        // out is a static member of the System class, and it is an instance of the PrintStream class. It provides methods for printing various data types to the console.
        // 1. System.out.print() prints the text without adding a new line at the end, while System.out.println() adds a new line after printing the text.
        // 2. You can use escape sequences (like \n for new line, \t for tab) in print statements to format the output as needed.
        // 3. The print statements can be used to display variables and expressions by concatenating them with strings using the + operator.
    }

    
}

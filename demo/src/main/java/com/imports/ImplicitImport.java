package com.imports;
import java.util.Date;
public class ImplicitImport {

    //Understand the concept of implicit import in Java
    //Implicit import is a feature in Java that allows you to use classes from the java.lang package without explicitly importing them. 
    // The java.lang package is automatically imported by the Java compiler, so you can use its classes without needing to specify an import statement.
    public static void main(String[] args) {
        // Example of implicit import
        // We can use the String class from the java.lang package without explicitly importing it:
        String str = "Hello, World!";
        System.out.println(str); // Output: Hello, World!
        
        Date date = new Date(); // Output: current date and time
        System.out.println(date.getClass().getName()); // to check id date is from which package 
        // Important points to remember:
        // 1. The java.lang package is automatically imported in every Java program, so you can use its classes without needing to import them explicitly.
        // 2. Implicit imports are limited to the java.lang package. If you want to use classes from other packages, you will need to use explicit imports.
        //3 ambiguity scenarios can arise if there are classes with the same name in different packages. In such cases, you may need to use fully qualified names to specify which class you want to use.
        //4 All import statements in Java are processed at compile time, and they do not affect the runtime behavior of the program. They are simply a way to make it easier for developers to reference classes without needing to specify their full package names.
        //5 In java import classed will beloaded whenever they are used in the code, not at the time of import statement. So, if you have an import statement for a class that is never used in your code, it will not be loaded into memory, and it will not affect the performance of your program.
    }
    
}

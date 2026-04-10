package com.Import;

public class ExplicitImport {

    //Understand the concept of explicit import in Java
    //Explicit import is a way to import specific classes or packages in Java. 
    // It allows you to use the imported classes without having to specify their fully qualified names every time you use them in your code.
    public static void main(String[] args) {
        // Example of explicit import
        // If we want to use the ArrayList class from the java.util package, we can explicitly import it at the beginning of our code:
        // import java.util.ArrayList;

        // Now we can create an instance of ArrayList without specifying its fully qualified name:
        // ArrayList<String> list = new ArrayList<>();

        // Important points to remember:
        // 1. Explicit imports are used when you want to use specific classes or packages in your code.
        // 2. It helps to improve code readability and maintainability by avoiding the need to specify fully qualified names for commonly used classes.
        // 3. Explicit imports can lead to naming conflicts if multiple classes with the same name are imported from different packages. In such cases, you may need to use fully qualified names to resolve the conflict.
    }
    
}

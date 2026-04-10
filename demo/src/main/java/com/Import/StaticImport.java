package com.Import;
import static java.lang.Math.*;


public class StaticImport {

    //Understand the concept of static import in Java from 1.5version of javs it is introduced in java
    //Static import is a feature in Java that allows you to access static members (fields and methods) of a class without needing to qualify them with the class name. 
    // It can make your code more concise and easier to read when you are using static members frequently.
    public static void main(String[] args) {
        // Example of static import
        // If we want to use the Math class's static methods, we can use static import:
        // import static java.lang.Math.*;

        // Now we can call the static methods of the Math class without qualifying them with the class name:
         double result = sqrt(16); // Output: 4.0
         System.out.println(result);
        // Important points to remember:
        // 1. Static import allows you to access static members of a class without qualifying them with the class name.
        // 2. It can improve code readability when you are using static members frequently, but it should be used judiciously to avoid confusion and maintain code clarity.
        // 3. Static import can lead to naming conflicts if multiple classes have static members with the same name. In such cases, you may need to use fully qualified names to resolve the conflict.
    }
    
}

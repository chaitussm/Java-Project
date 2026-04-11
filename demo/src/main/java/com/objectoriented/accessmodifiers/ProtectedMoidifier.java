package com.objectoriented.accessmodifiers;

public class ProtectedMoidifier {

    // The protected access modifier allows the class, method, or variable to be accessed from any other class in the same package or from any subclass in any package.
    // It is more permissive than the default access modifier but more restrictive than the public access modifier.
    // A class, method, or variable declared as protected can be accessed by any other class in the same package, as well as by any subclass in any package.
    // It is important to use the protected access modifier when you want to allow access to a class, method, or variable from subclasses while still restricting access from other classes in different packages.
    protected String name = "Protected Access Modifier";

    public static void main(String[] args) {
        ProtectedMoidifier obj = new ProtectedMoidifier();
        System.out.println("Name: " + obj.name);
    }
    
}

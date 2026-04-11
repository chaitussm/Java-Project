package com.AccessModifiers;

public class DefaultModifier {

    // The default access modifier, also known as package-private, allows the class, method, or variable to be accessed only within the same package.
    // It is the default access level when no access modifier is specified.
    // A class, method, or variable declared with default access can be accessed by any other class in the same
    // package, but cannot be accessed from classes in other packages.
    // It is important to use the default access modifier when you want to restrict access to a class, method, or variable to only within the same package, while still allowing access to other classes in the same package.
    String name = "Default Access Modifier";  
    //We can initialize the variable with default access modifier without using any access modifier, it will be accessible only within the same package and it will not be accessible from classes in other packages.  

    public static void main(String[] args) {
        DefaultModifier obj = new DefaultModifier();
        System.out.println("Name: " + obj.name);
    }
    
}

package com.AccessModifiers;

public class PrivateModifier {
    
    // The private access modifier restricts the access of a class, method, or variable to only within the same class.
    // It is the most restrictive access level and cannot be accessed from any other class, even if they are in the same package.
    // A class, method, or variable declared as private can only be accessed by other members of the same class.
    // It is important to use the private access modifier to encapsulate data and functionality within a class, and to prevent unintended access from other classes or packages.
    private String name; 
    
    //By using setters and getters is called encapsulation, it is a fundamental principle of object-oriented programming that allows you to hide the internal details of a class and provide
    public void getName() {
        System.out.println("Name: " + name); 
    }

    public void setName(String name) {
        this.name = name; 
    }
    public static void main(String[] args) {
        PrivateModifier obj = new PrivateModifier();
        obj.setName("Java Access Modifiers"); 
    }

    
}

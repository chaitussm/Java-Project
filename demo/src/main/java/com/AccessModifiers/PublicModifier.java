package com.AccessModifiers;

public class PublicModifier {

    // The public access modifier allows the class, method, or variable to be accessed from any other class in the same package or from any other package.
    // It is the most permissive access level and can be accessed from anywhere in the program.
    // A class, method, or variable declared as public can be accessed by any other class, regardless of the package it belongs to.
    // It is important to use the public access modifier judiciously, as it can lead to security issues if sensitive data or functionality is exposed to unintended classes or packages.
    public String name; 

    public static void main(String[] args) {
        PublicModifier obj = new PublicModifier();
        obj.name = "Java Access Modifiers";
        System.out.println("Name: " + obj.name);
    }
    
}

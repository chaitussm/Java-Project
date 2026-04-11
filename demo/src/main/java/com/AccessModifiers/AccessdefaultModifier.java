package com.AccessModifiers;

public class AccessdefaultModifier extends DefaultModifier {

    // The default access modifier, also known as package-private, allows the class, method, or variable to be accessed only within the same package.
    // It is the default access level when no access modifier is specified.
    // A class, method, or variable declared with default access can be accessed by any other class in the same package, but cannot be accessed from classes in other packages.
    // It is important to use the default access modifier when you want to restrict access to a class, method, or variable to only within the same package, while still allowing access to other classes in the same package.
    public static void main(String[] args) {
        AccessdefaultModifier obj = new AccessdefaultModifier();
        System.out.println("Name: " + obj.name);

        // Important points to remember:
        // 1. The default access modifier allows access to classes, methods, and variables only within the same package.
        // 2. It is the default access level when no access modifier is specified.
        // 3. A class, method, or variable declared with default access cannot be accessed from classes in other packages, but can be accessed by any other class in the same package.
        // 4. It is important to use the default access modifier when you want to restrict access to a class, method, or variable to only within the same package, while still allowing access

    }
}

package com.objectoriented.Inheritance;

public class BaseClass {

    //Base class is also called as parent class or super class. It is the class from which other classes can inherit properties and behaviors. The base class can have its own fields and methods, and it can also be extended by other classes to create a hierarchy of classes.
    // In Java, a base class is defined using the "class" keyword, and it can be extended by other classes using the "extends" keyword. The base class can have constructors, methods, and fields that can be inherited by the subclasses.
    // The base class can also have access modifiers (public, protected, private) that determine the visibility of its members to the subclasses. The subclasses can override the methods of the base class to provide their own implementation, and they can also add new methods and fields to enhance their functionality.
    // The base class is an important concept in object-oriented programming as it promotes code reusability and allows for a hierarchical classification of classes.

    public void display() {
        System.out.println("This is the base class.");
    }

    public static void main(String[] args) {
        BaseClass base = new BaseClass();
        base.display();
    }
}

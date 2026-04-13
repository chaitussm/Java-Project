package com.fundamentals.Interface;

interface Bank{
    
    void deposit();
    void reporate();

    double roi = 9.5;
}

public class InterfaceDef implements Bank {
    
    // An interface in Java is a reference type that defines a set of abstract methods that a class can implement. It is a way to achieve abstraction and multiple inheritance in Java.
    // An interface can contain only abstract methods (methods without a body) and constants (static final variables). It cannot contain instance variables or concrete methods (methods with a body).
    // A class that implements an interface must provide an implementation for all the abstract methods defined in the interface. This allows for a common contract that multiple classes can adhere to, enabling polymorphism and code reusability.
    // Interfaces are often used to define a common behavior that can be shared across different classes, regardless of their class hierarchy. They are also used to achieve loose coupling between classes, as they allow for the separation of concerns and promote modular design.
    
    public void deposit() {
        System.out.println("Deposit method implementation");
    }

    public void reporate() {
        System.out.println("Reporate method implementation");
    }
    
    public static void main(String[] args) {
        InterfaceDef obj = new InterfaceDef();
        obj.deposit();
        obj.reporate();
        System.out.println("Rate of Interest: " + Bank.roi);
    }

    
}

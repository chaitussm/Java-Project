package com.objectoriented.accessmodifiers;

public class FinalModifier {

    final String name = "Final Access Modifier";
    //static variable can be accessed without creating an instance of the class, and it is shared among all instances of the class.
    static final String data;
    final String detail;
    //final local variable


    final static void display() {
        final int localVariable = 10;
        System.out.println("This is a final method." + " Local variable: " + localVariable);
    }

    // we can initialize the final variable in static block or in constructor

    static {
        
        data  = "Final Access Modifier data";
    }

    FinalModifier() {
        detail = "Final Access Modifier detail";
    }
    // The final access modifier is used to declare a class, method, or variable as final, which means that it cannot be modified or overridden.
    // A final class cannot be subclassed, a final method cannot be overridden by subclasses, and a final variable cannot be reassigned after it has been initialized.
    // The final access modifier is often used to create immutable classes or to prevent unintended modifications to critical code.
    // It is important to use the final access modifier judiciously, as it can limit the flexibility of your code and make it more difficult to maintain in the long run.
    public static void main(String[] args) {
        System.out.println("Final Access Modifier");
        display();
        System.out.println("Name: " + new FinalModifier().name);
        System.out.println("Data: " + data);
        System.out.println("Detail: " + new FinalModifier().detail);
    }
    
}

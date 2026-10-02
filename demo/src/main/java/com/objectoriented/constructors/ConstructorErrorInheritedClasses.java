package com.objectoriented.constructors;

public class ConstructorErrorInheritedClasses extends DefaultConstructor{

    /*  NOTE
    Important example to understand default constructors and their behavior with inheritance.
    Scenario 1
    If neither superclass nor subclass defines a constructor, the code compiles: the compiler provides default no-arg constructors.
    
    Scenario 2
    If the superclass defines a constructor but the subclass does not, the compiler generates a default no-arg constructor
    in the subclass that calls `super()`:
    
    constructorError() {
        super();
    }

    Scenario 3
    If the superclass only defines a constructor with parameters (for example `DefaultConstructor(int a)`), and the
    subclass does not provide a matching constructor, compilation fails with an error like:
    
    cannot find symbol: constructor DefaultConstructor()
    location: class com.objectoriented.constructors.DefaultConstructor
    */
    public static void main(String[] args) {
        System.out.println("Constructor basics");
    }


    
}

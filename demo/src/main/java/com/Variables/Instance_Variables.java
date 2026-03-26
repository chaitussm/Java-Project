package com.Variables;

public class Instance_Variables {

    //Rules for instance varables 
    //1. Instance variables are declared inside the class but outside the method, constructor or any block.
    //2. Instance variables are created when an object of the class is created and destroyed when the object is destroyed.
    //3. Instance variables can be accessed directly by calling the variable name or by using the object reference variable.
    //4. Instance variables are initialized to default values if not explicitly initialized by the programmer. The default values are 0 for numeric types, false for boolean
    //   and null for object references.
    //5. Instance variables can be accessed by all the methods in the class and can be used to store the state of an object.
    //6 instance varaibles values can be changed from object to object 
    //7 Instance varaibles are stored in Heap memory and they are called as Object variables or attributes of the class.

    String name; // instance variable
    int age; // instance variable

    public static void main(String[] args) {
        Instance_Variables obj1 = new Instance_Variables();
        obj1.name = "Seetha";
        obj1.age = 25;

        Instance_Variables obj2 = new Instance_Variables();
        obj2.name = "Rama";
        obj2.age = 30;

        System.out.println("Object 1: Name = " + obj1.name + ", Age = " + obj1.age);
        System.out.println("Object 2: Name = " + obj2.name + ", Age = " + obj2.age);
    }
    
}

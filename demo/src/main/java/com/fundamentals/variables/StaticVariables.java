package com.fundamentals.variables;

public class Static_Variables {
    
    //Rules for static variables 
    //1. Static variables are declared inside the class but outside
    //   the method, constructor or any block and are declared with the static keyword.
    //2. Static variables are created when the class is loaded and destroyed when the class is
    //   unloaded.
    //3. Static variables can be accessed directly by calling the variable name or by using the class name.
    //4. Static variables are initialized to default values if not explicitly initialized by the programmer. The default values are 0 for numeric types, false for boolean and null for object references.
    //5. Static variables can be accessed by all the methods in the class and can be used to store the state of the class.
    //6. Static variables values are created at class level and shared among all the objects of the class.
    //steps of program execution 
    //a.start JVM
    //b.create and start main method thread
    //c.load class(here Static_Variables class is loaded)
    //d.execute main method
    //e.unload class(here Static_Variables class is unloaded)
    //end main method thread
    //shut down JVM
    //Static varaibles are stored in method area memory and they are called as class level variables or class attributes of the class.
    
    static String name; // static variable
    static int age; // static variable  

    public static void main(String[] args) {
        Static_Variables.name = "Seetha";
        Static_Variables.age = 25;

        System.out.println("Name = " + Static_Variables.name + ", Age = " + Static_Variables.age);
    }
}

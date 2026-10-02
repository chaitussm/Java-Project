package com.objectoriented.constructors;

//The only modifiers used for the construtors are public , private , protected andf default 

public class constructore_voidMethod {
    
    constructore_voidMethod()
    {
        System.out.println("Constructor is invoked");
    }

    //here if we take void before constructor name then we wont get any compile time errors but compiler 
    //treats it is an ordinary method But this is not a good programming practice to take method name same as constructor name because it creates confusion for the programmer.
    void constructore_voidMethod()
    {
        System.out.println("This is void method with same name as constructor");
    }
    
    public static void main(String[] args) {
        
        constructore_voidMethod obj = new constructore_voidMethod();
        obj.constructore_voidMethod();

    }
    
}

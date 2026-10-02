package com.objectoriented.constructors;

//NOTE
//1.Inheritance concept and overriding concept are not available for the construtors
//2.Abstract classes contains constructors 
//3.For Interafces construtors are nto available

public class OverloadConstructors {
    
      OverloadConstructors()
    {
        this(10);
        System.out.println("No-Arg Constructor");
    }
    
    OverloadConstructors(int i)
    {
        this(11.2);
        System.out.println("Int-Arg Constructor");
    }
    
    OverloadConstructors(double d)
    {
        System.out.println("Double-Arg Constructor");
    }
    
    
    
    public static void main(String[] args) {
       
       OverloadConstructors obj = new OverloadConstructors();
       OverloadConstructors obj1 = new OverloadConstructors(10);
       OverloadConstructors obj2 = new OverloadConstructors(9l);
    }
}

package com.objectoriented.constructors;

//NOTE
//1.Inheritance concept and overriding concept are not available for the construtors
//2.Abstract classes contains constructors 
//3.For Interafces construtors are nto available

public class overloadConstructors {
    
      overloadConstructors()
    {
        this(10);
        System.out.println("No-Arg Constructor");
    }
    
    overloadConstructors(int i)
    {
        this(11.2);
        System.out.println("Int-Arg Constructor");
    }
    
    overloadConstructors(double d)
    {
        System.out.println("Double-Arg Constructor");
    }
    
    
    
    public static void main(String[] args) {
       
       overloadConstructors obj = new overloadConstructors();
       overloadConstructors obj1 = new overloadConstructors(10);
       overloadConstructors obj2 = new overloadConstructors(9l);
    }
}

package com.objectoriented.typeCasting;

public class typeCastingDef {

    // Type casting is the process of converting a variable from one data type to another. In Java, there are two types of type casting: 
    // 1. Primitive type casting: This involves converting between primitive data types such as int, float, double, etc. There are two types of primitive type casting: 
    // a. Widening (automatic) type casting: This occurs when a smaller data type is converted to a larger data type. For example, converting an int to a double. This is done automatically by the Java compiler.
    // b. Narrowing (manual) type casting: This occurs when a larger data type is converted to a smaller data type. For example, converting a double to an int. This requires explicit casting by the programmer and may result in loss of precision or data.
    
    // 2. Reference type casting: This involves converting between reference types such as classes and interfaces. There are two types of reference type casting:
    // a. Upcasting: This occurs when a subclass reference is assigned to a superclass reference. For example, if we have a class Dog that extends Animal, we can assign a Dog object to an Animal reference. This is done automatically by the Java compiler.
    // b. Downcasting: This occurs when a superclass reference is assigned to a subclass reference. For example, if we have an Animal reference that points to a Dog object, we can cast it back to a Dog reference. This requires explicit casting by the programmer and may result in a ClassCastException if the object being cast is not actually an instance of the subclass.

      public static void typeCasting()
    {
        Integer I = new Integer(10);
        
        Object obj = (Object)I; 
        
        System.out.println("Value of obj is  : " +  obj);
    }
    
    public static void upCasting()
    {
        float f = 10.0f;
        
        Object a = (Object)f ;
        
        System.out.println("Upcasting of float to Object : and a value is : " + a );
    }
    
    public static void downCasting()
    {
        String s = "string";
        
        Object c = (Object)s; 
        
        System.out.println("Down casting of int to char : and a value is : " + c);
    }
    
    public static void main(String[] args) {
        
        typeCasting();
        upCasting();
        downCasting();
    }
    
}

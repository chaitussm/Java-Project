package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class overloadingWithAutoBoxingOne
{
   
    public static void method(Long l)
    {
        System.out.println("Long");
    }

    public static void method1(Object o)
    {
        System.out.println("Object");
    }

    public static void main(String[] args)
    {
        int x = 10;
        /*method(x); widening followed by autoboxing is not allowed in java 
        Autoboxing and then widening is allowed in java*/

        method1(x); 
        /*Here first int by using autoboxing changed to Integer and then by using widening Integer to Object
         * int -------> Integer ------> Object 
         * following assignments are correct */
          int i = 10;
          Integer I = 10;//autoboxing valid 
          /*int i1 = 10L;//cannot convert from int to legal: 
          possible loss of precesion
          found : long 
          required : int */
          Long j = 10L; //Autoboxing
          /*Long k = 10; incompatable types 
          found : int 
          required : long */
          long k = 10; // Widening
          Object o = 10; // Autoboxing followed by Widening 
          double d = 10; // Widening
          /*Double D = 10; int to Long , int to Double not possible 
          incompatible types  
          found : int  
          required : Double*/
          Number n = 10; // Autoboxing followed by widening




         
    }
}
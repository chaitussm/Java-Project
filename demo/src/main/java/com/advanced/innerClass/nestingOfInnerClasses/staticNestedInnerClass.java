package com.advanced.innerClass.nestingOfInnerClasses;

public class staticNestedInnerClass
{
    /*
     *
     *
     * from normal or regular inner classes we can access both static and non-static members of 
     * outer class directly but from static nested clsses we can access static members of outer class directly 
     * and we cant access non-static members
     */
    static class Nested 
    {
        public static void main(String[] args)
        {
            System.out.println("static nested class main method");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("outer class main method");
    }
}
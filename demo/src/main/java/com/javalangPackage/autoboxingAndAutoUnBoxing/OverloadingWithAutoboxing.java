package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class OverloadingWithAutoboxing {

    /*
     * Overloading with respect to Autoboxing , widening and var-arg methods
     *
     * 
     */
    
    public static void concept(Integer i)
    {
        System.out.println("Auto-Boxing");
    }

    public static void concept(long l)
    {
        System.out.println("Widening");         
    }

    public static void main(String[] args)
    {
        int x = 10;

        concept(x);/*Widening dominates autoboxing*/


    }
}

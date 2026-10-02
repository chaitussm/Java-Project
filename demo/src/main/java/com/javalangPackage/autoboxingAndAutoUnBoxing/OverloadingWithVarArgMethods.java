package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class overloadingWithVarArgMethods
{
    public static void concept(int...x)
    {
        System.out.println("Var-Arg Methods");
    }

    public static void concept(long l)
    {
        System.out.println("Widening");
    }

    public static void concepts(int...x)
    {
        System.out.println("Var-Arg Methods");
    }

    public static void concepts(long l)
    {
       System.out.println("AutoBoxing");
    }

    public static void main(String[] args)
    {
        int x = 10;
        concept(x);/*Widening will get the chance*/
        concepts(x);
    }
}
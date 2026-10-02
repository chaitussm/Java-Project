package com.javalangPackage.variousMethods;

import java.lang.reflect.*;
public class getClassMethods {

    /*
        *
        *
        * In this example we are going to see various methods of Object class
        * We can use getClass() method to get the runtime class defintion of an object 
        * public final Class getClass() 
        * By using this Class class Object we can access class level properties like fully qualified name of the class, methods, fields, constructors etc
        * We can use getClass() method very frequently in reflection API to get the class level properties of an object
    
     */

    public void getClassMethod(Object obj) 
    {
        Class c = obj.getClass();
        System.out.println("Fully qualified name of the class : " + c.getName());
        Method[] m = c.getDeclaredMethods();
        int count = 0;
        for(Method m1: m)
        {
           count++;
           System.out.println(m1.getName());
        }

        System.out.println("Number of methods available : " + count);
    }

    public static void main(String[] args) throws Exception
    {
        //For the same class
        getClassMethods obj = new getClassMethods();
        obj.getClassMethod(obj);
        //For String Class 
        String s = new String("Shiva");
        obj.getClassMethod(s);
    }
    
}

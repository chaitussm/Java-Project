package com.javalangPackage.variousMethods;

import java.lang.reflect.*;

public class ObjectBased {
    /*
     *
     *
     * if our class doesnt extend any other class then only our class is the direct child class of Object
     * In this example Object based is the child of Object class 
     * Object class defines the following 11 methods 
     * public String toString()
     * public native int hashcode()
     * public boolean equals(Objace o)
     * protected native Object clone() throws CloneNotSupportedException
     * protected finalize() throws Throwable
     * public final Class getClass()
     * public final void wait() throws InterruptedException
     * public final native void wait(long ms) throws InterruptedException
     * strictly speakin object class contains 12 methods that extra method is register natives
    */

    public static void main(String[] args) throws Exception
    {
        int count = 0;
        Class cs = Class.forName("java.lang.Object");

        Method[] m = cs.getDeclaredMethods();

        for(Method m1: m)
        {
           System.out.println(m1.getName());
           count++;
        }    

        System.out.println("Number of methods available : " + count);
    }
}

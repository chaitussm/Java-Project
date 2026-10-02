package com.javalangPackage.variousMethods;

import java.util.*;

public class toStringMethod {

    /*
     *
     *
     * We can use toString() to get string representation of an object  
     * Whenever we are trying to print object reference internally toString() wil be called
     * If our class doesnt contain toString() then Object class toStirng() will be executed
     * In all wrapper classes , all collection classes string class stringBuffer and stringBuilder 
     * classes toString() is overridden for meaningful string representation, Hence it is highlt 
     * recommended to override toString() in our class also
     */
       
    String name;
    int rollno;

    toStringMethod(String name, int rollno)
    {
       this.name = name;
       this.rollno = rollno;
    }

    public String toString()
    {
       // return getClass().getName() + "@" + Integer.toHexString(hashCode());
       return name + "===" + rollno;
    } //we can override the toString()*/


    public static void main(String[] args)
    {
       toStringMethod st = new toStringMethod("Shiva", 1);
       toStringMethod st1 = new toStringMethod("Parvathi", 2);
       System.out.println(st);
       System.out.println(st.toString());
       System.out.println(st1);

       //ArrayList, Integer wrapper classes
       String s = new String("durga");
       System.out.println(s);
       Integer I = new Integer(10);
       System.out.println(I);
       ArrayList al = new ArrayList();
       al.add("Shiva");
       al.add("Parvathi");
       System.out.println(al);
       



    }
    
}

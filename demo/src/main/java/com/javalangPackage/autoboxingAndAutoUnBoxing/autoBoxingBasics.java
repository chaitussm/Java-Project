package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class autoBoxingBasics {


    public static void autoBoxingDef()
    {
       //Automatic conversion of primitive to wrapper object by compiler is called autoboxing; 
       Integer I = 10; /*Compiler converts int to Integer Automatically by autoboxing
       After compilation the above line will become
       Integer I = Integer.valueOf(10); i.e internally autoboxing concept is implemented by using valueOf() methods */
    }

    public static void autoUnBoxingDef()
    {
        /*Automatic Conversion of wrapper object to primitive by compiler is called autounboxing*/

        Integer I = new Integer(10);

        int i = I;

        /*Compiler converts Integer to int automatically by autounboxing After compilation the above will become 
          
        int i = I.intValue(); i.e internally autounboxing concept is implemented by using xxxvalue() methods
        */
    }
    
    static Integer I = 10;
    public static void autoBoxingUnBoxing(Integer k)
    {
        int m = k;
        System.out.println(m);
    }

    public static void main(String[] args)
    {
        autoBoxingDef();
        autoUnBoxingDef();

        int i = I ;
        autoBoxingUnBoxing(i);
    }
    
}

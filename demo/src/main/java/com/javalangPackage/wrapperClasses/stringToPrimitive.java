package com.javalangPackage.wrapperClasses;

public class stringToPrimitive {

    /*
     *
     *
     * We can use parsexxx methods to convert from String to primitive
     * 
     * public static primitive parsexxx(String s)
     * NOTE: 
     * Wrapper Objects to String : toString() 
     * String to primitive : parsexxx()
     * primitive to wrapper Object : valueOf()
     * wrapper Object to primitive : xxxvalue()
     * primitive to String() : toString()
     * String to wrapper Object : valueOf()
     * In addition to String Objects all wrapper class objects also immutable void class is also considered as wrapper class.
     */



    public static void formOne()
    {
        //Every wrapper class except Character class contains the following parsexxx() to find primitve for the given String Object
        int i = Integer.parseInt("10");
        double d = Double.parseDouble("10.5");
        Boolean b = Boolean.parseBoolean("true");
        
        System.out.println("Values are :" + i + d + b);
    }

    public static void formTwo()
    {
        /*Every integral type wrapper class byte,short,integer, long contains the following parsexxx(0 to convert 
         specified radix string to primitive 
         public static primitve parsexxx(String s , int radix);
         the allowed range of radix is 2 to 36*/

         int i = Integer.parseInt("1111", 2);
         System.out.println(i);
    }

    public static void formThree() 
    {
        /*public static String toString(primitve p)
          We can use toString() to convery wrapper object or primitive to String
          It is the orverriding version of object class toString() method 
          Every wrapper class including character class contains the following static toString() to convert primitive to String*/

        String s = Integer.toString(10);
        String b = Boolean.toString(true);
        String c = Character.toString('a');

        System.out.println("Conevrted Strings are :" + s + b + c);
    }

    public static void formFour()
    {
        /*Integer and Long classes contains the following toString() to convert primitive to specified radix String
          public static String toString(primitve p , int radix) the allowed to range of radix 2 to 36
          */

          String s = Integer.toString(15, 2);
          System.out.println("Converted Specified radix String is :" + s);
    }

    public static void formFive()
    { 
        /*Integer and Long classes contains the following toxxxString() 
          
        public static String toBinaryString(primitve p)
        public static String toOctalString(primitve p)*/

        String s = Integer.toBinaryString(10);
        System.out.println("10 after converting to Binary:" + s);

    }



    public static void main(String[] args)
    {
        formOne();
        formTwo();
        formThree();
        formFour();
        formFive();
    }
    
}

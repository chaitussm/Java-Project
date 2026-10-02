package com.javalangPackage.wrapperClasses;

public class wrapperBasics {
    
    /*
     *
     *
     * The main objectives of wrapper classes are to convert primitive data types into objects and vice versa
     * To define several utility methods to perform operations on primitive data types
     * Almost all wrapper classes contains 2 constructors one can take corresponding primitive data type as argument and 
     * another can take String as argument
     * If String argument not representing a number then we will get runtime exception saying NumberFormatException
     * Float class contains 3 constructors with float, double and String arguments
     * Boolean contains 2 constructors boolean and String, if we are passing String type as argument then case and content both are not important
     * If the content is case-insensitive string of true then it is treated as true otherwise it is treated as false
     * Boolean class  contains booleanValue() to get Boolean primitve for the given Boolean Object 
     * Character contains 1 constructor
     * Character class contaisn charValue() to get char primitive for the given character object
     * Every number type wrapper class(Byte,Short,Integer,Float, Double) contains following 6 methods to get primitive for the given wrapper object
     * In total 38 (equal to 6*6 + 1 + 1) xxxvalue methods are possible.
     */
    
    public static void methodsInWrapperClass()
    {
        Integer I = new Integer(130);
        System.out.println(I.byteValue());
        System.out.println(I.shortValue());
        System.out.println(I.intValue());
        System.out.println(I.longValue());
        System.out.println(I.floatValue());
        System.out.println(I.doubleValue());
    }

    public static char charValue()
    {
        Character c = new Character('a');
        char cs = c.charValue();
        
        System.out.println(cs);

        return c;
    }

    public static Boolean booleanValue()
    {
        Boolean b = Boolean.valueOf("Shiva");
        Boolean bl =  b.booleanValue();

        System.out.println(bl);

        return bl;
    }
    public static void IntegerwrapperClassConstructors()
    {
        Integer I1 = new Integer(10); //Integer class constructor which takes int as argument
        Integer I2 = new Integer("10"); 
        System.out.println(I1);
        System.out.println(I2);
        //Integer I3 = new Integer("ten"); NumberFormatException
    }
    
    public static void floatwrapperClassConstructors()
    {
        Float f = new Float(10.5f);
        Float f1 = new Float("10.5f");
        Float f2 = new Float(10.5);
        System.out.println(f);
        System.out.println(f1);
        System.out.println(f2);

    }

    public static void booleanWrapperClass()
    {
        Boolean a = new Boolean("yes");
        Boolean b = new Boolean("no");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));
    }

    public static void main(String[] args)
    {
        IntegerwrapperClassConstructors();
        floatwrapperClassConstructors();
        booleanWrapperClass();
        methodsInWrapperClass();
        char c = charValue();
        System.out.println("charValue is :" + c);
        boolean bl = booleanValue();
        System.out.println("Boolean value is:" + bl);
    }
}

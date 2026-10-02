package com.javalangPackage.wrapperClasses;

public class ValueOfMethod {

    /*
     *
     * we can use valueOf() methods to create wrapper object for the given primitive or string
     * Every wrapper class except character class contains a static valueOf() method to create wrapper object for the given string
     * The allowed range of radix is 2 to 36
     * Every wrapper class including character class contains a static valueOf() method to create wrapper object for the given primitive
     * 
     */
    
    public static void valueOfFirstmethod()
    {
         //public static wrapper valueOf(String s)

       Integer i = Integer.valueOf("10");
       Double d = Double.valueOf("10.5");
       Boolean b = Boolean.valueOf("durga");
       System.out.println(i);
       System.out.println(d);
       System.out.println(b);
    }

    public static void valueOfSecondMethod()
    {
        //public static wrapper valueOf(String s , int radix)

       Integer i = Integer.valueOf("1111" , 2);
       
       System.out.println(i);
    }

    public static void valueOfThirdMethod()
    {
       Integer i = Integer.valueOf(10);
       Character d = Character.valueOf('a');
       Boolean b = Boolean.valueOf(true);
       System.out.println(i);
       System.out.println(d);
       System.out.println(b);
    }
    public static void main(String[] args)
    {
      valueOfFirstmethod();
      valueOfSecondMethod();
      valueOfThirdMethod();
    }
    
}

package com.javalangPackage.autoboxingAndAutoUnBoxing;

public class autoBoxingExample2 {

    public static void example()
    {
        Integer X = new Integer(10);// new object is created in heap with X pointing to 10 
        Integer Y = new Integer(10);// new object is created in heap with Y pointing to 10 
        
        System.out.println("Output for example is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 
    }

     public static void exampleOne()
    {
        Integer X = new Integer(10);// new object is created in heap with X pointing to 10 
        Integer Y = 10;// new object is created in heap with Y pointing to 10 
        
       System.out.println("Output for exampleOne  is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 
    }

     public static void exampleTwo()
    {
        Integer X = 10;// new object is created in heap with X pointing to 10 
        Integer Y = 10;/*Here JVM checks if an object is created for the object refernce 
        10 already above object is created so with the same refrence Y */
        
        System.out.println("Output for exampleTwo is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 10 
    }

     public static void exampleThree()
    {
        Integer X = 100;// new object is created in heap with X pointing to 10 
        Integer Y = 100;/*Here JVM checks if an object is created for the object refernce 
        10 already above object is created so with the same refrence Y */
        
       System.out.println("Output for exampleThree is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 10 
    }

    public static void exampleFour()
    {
        Integer X = 1000;// new object is created in heap with X pointing to 10 
        Integer Y = 1000;/*Here JVM checks if an object is created for the object refernce 
        10 already above object is created so with the same refrence Y */
        
       System.out.println("Output for exampleFour is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 10 
    }

    public static void exampleFive()
    {
        Double X = 10.0;/* New object will be created because Double and float doesnt have the previlege to use the buffer or range provided below so 
        new objects are created separately*/
        Double Y = 10.0;
        
       System.out.println("Output for exampleFive is : " + (X == Y));// For == symbol both objects should be pointing towards same reference 10 
    }
    public static void main(String[] args)
    {
        Integer X = 10;

        Integer Y = X;

        X++;/*Here all wrapper classes are immutable, hence the incremented value 11 will be created as new object and 
        and X is pointing towards 11 when == X and Y are pointing to different objects then result is false*/

        System.out.println(X);
        System.out.println(Y);
        System.out.println(X==Y);

        example();
        exampleOne();
        exampleTwo();
        exampleThree();
        exampleFour();
        exampleFive();

        /*
         *
         * Internally to provide the support for auto boxing a buffer of wrapper objects will be created at the time of wrapper 
         * class loading by autoboxing if an object is required to create first JVM will check if this object already present 
         * in the buffer(range) or not if it already present in the buffer then existing buffer object will be used
         * if it not already available in the buffer then JVM will create a new object 
         * But buffer concept is available only in the follwing ranges 
         * Byte ---------------> always 
         * Short --------------> -128 to +127 
         * Integer --------------> -128 to +127
         * Long --------------> -128 to +127
         * Character --------------> 0 to +127
         * Boolean --------------> always 
         * Except this range in all remaining cases a new object will be created 
         */
    }
    
}

package com.advanced.innerClass.example2;

public class outerClassDemo {

    public static void main(String[] args)
    {
       sampleClass ot = new sampleClass();
       
       /*
        * from normal or regular inner class we can access both static and non-static members of outer class directly
       */
       sampleClass.Inner in = ot.new Inner();

       in.m1();
    }
    
    
}

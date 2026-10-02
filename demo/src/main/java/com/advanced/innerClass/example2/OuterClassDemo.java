package com.advanced.innerClass.example2;

public class OuterClassDemo {

    public static void main(String[] args)
    {
       SampleClass ot = new SampleClass();
       
       /*
        * from normal or regular inner class we can access both static and non-static members of outer class directly
       */
       SampleClass.Inner in = ot.new Inner();

       in.m1();
    }
    
    
}

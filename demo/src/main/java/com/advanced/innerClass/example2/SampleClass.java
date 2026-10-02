package com.advanced.innerClass.example2;

public class SampleClass {

    int x = 10;
    static int y = 20;

    class Inner
    {
        public void m1()
        {
            System.out.println(x);
            System.out.println(y);
        }
    }
    
}

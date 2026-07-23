package com.advanced.innerClass.example3;

public class toAccessvariablesInclasses {

    int x = 10;

    class Inner{

        int x = 100;

        public void m1()
        {
            int x = 1000;

            System.out.println(x);

            /*To print the x value outside the method and inside the inner class*/

            System.out.println(this.x);

            /*To print the value of x present in the outer class*/

            System.out.println(toAccessvariablesInclasses.this.x);
        }
    }

    public static void main(String [] args)
    {
        toAccessvariablesInclasses ta = new toAccessvariablesInclasses();
        
        toAccessvariablesInclasses.Inner in = ta.new Inner();

        in.m1();
    }
    
}

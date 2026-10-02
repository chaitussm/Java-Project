package com.advanced.innerClass.methodLocal;

public class MethodLocalInnerClass {

     /*
      * To define method specific repeated required funtionality
      * method local inner classes are best suitable to meet nested method requirements
      */

    public void m1()
    {
        class Inner{

            public void sum(int x, int y)
            {
                System.out.println("Sum is :" + (x+y));
            }
        }

        Inner i = new Inner();

        i.sum(1,2);
        i.sum(3,4);
    }

    public static void main(String[] args)
    {
        MethodLocalInnerClass n = new MethodLocalInnerClass();

        n.m1();
    }
    
}

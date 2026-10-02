package com.advanced.innerClass.nestingOfInnerClasses;

import com.advanced.innerClass.nestingOfInnerClasses.NestingInnerClass.InnerA.InnerB;

public class NestingInnerClass {

    class InnerA
    {
        class InnerB
        {
            class InnerC
            {
                public void m1()
                {
                    System.out.println("I am the innermost class");
                }
            }
        }
    }

    public static void main(String[] args)
    {
        NestingInnerClass n = new NestingInnerClass();

        NestingInnerClass.InnerA in = n.new InnerA();

        InnerA.InnerB inb = in.new InnerB();

        InnerB.InnerC inc = inb.new InnerC();

        inc.m1();
    }
    
}

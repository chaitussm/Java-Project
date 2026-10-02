package com.advanced.innerClass.methodLocal;

public class methodLocalWithLocalVariable {

    /*
     *
     * From method local inner class we cant access local variables of the method in which we declare inner class 
     * If the local variable decalred as final then we can access
     * we cannnot access the local variables from the method using Inner classes until it is decalred as final
     * When the local variable is declared as the final at the compile time evry final variable is repalced by the value.
     * The if the m1() is destroyed after calling existing object left method2() from the i object reference
     * Inside inner classes we cannot decalare static members
     * possible modifiers for the method local inner classes final, abstract and strictfp

     */
     
    

    public void method1()
    {

        final int x = 10;
        class Inner
        {
            public void method2()
            {
                System.out.println(x);
            }
        }

        Inner n = new Inner();
        n.method2();
    }

    public static void main(String[] args)
    {
        methodLocalWithLocalVariable n = new methodLocalWithLocalVariable();

        n.method1();
    }
    
}

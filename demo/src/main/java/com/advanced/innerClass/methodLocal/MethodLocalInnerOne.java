package com.advanced.innerClass.methodLocal;

public class methodLocalInnerOne {

    /*
     * If we declare inner class inside instance method then, from thjat method ocal inner class 
     * we can access both static and non-static members of outer class directly
     * if we declare inner class inside static method then we can access only static memebrs of outer class directly
     * from that method local inner class 
     *  


     */
    
    int x = 10;

    int y = 20;

    public void method1()
    {
        class Inner
        {
            public void method2()
            {
                System.out.println(x);
                System.out.println(y);
            }

          
        }

          Inner in = new Inner();

            in.method2();
    }

    public static void main(String[] args)
    {
        methodLocalInnerOne n = new methodLocalInnerOne();

        n.method1();
    }
}

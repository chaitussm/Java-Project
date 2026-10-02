package com.advanced.multiThreading.multipleLock;

public class multiLock{

    public synchronized void method1() {
       
       classA a = new classA();
       synchronized(a) {
           a.methodA();
           classB b = new classB();
           b.methodB();
            synchronized(b)
            {
              classC c = new classC();
               synchronized(c)
              {  
               c.methodC();
              }
            }
       }
      
    }
    
    public static void main(String[] args) {
        multiLock m = new multiLock();
        m.method1();
    }
   


}

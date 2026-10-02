package com.advanced.multiThreading.multipleLock;

public class MultiLock{

    public synchronized void method1() {
       
       ClassA a = new ClassA();
       synchronized(a) {
           a.methodA();
           ClassB b = new ClassB();
           b.methodB();
            synchronized(b)
            {
              ClassC c = new ClassC();
               synchronized(c)
              {  
               c.methodC();
              }
            }
       }
      
    }
    
    public static void main(String[] args) {
        MultiLock m = new MultiLock();
        m.method1();
    }
   


}

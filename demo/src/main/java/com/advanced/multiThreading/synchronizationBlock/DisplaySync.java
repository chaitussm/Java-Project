package com.advanced.multiThreading.synchronizationBlock;

public class displaySync {

     public void wish(String name)
     {
        synchronized (this) {
            for(int i = 0 ; i<=7; i++)
            {
                System.out.println("Good morning ");
       
                try{
           
                    Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
       
                System.out.print(name);
            }
        }
   }
    
}

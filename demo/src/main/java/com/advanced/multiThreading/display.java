package com.advanced.multiThreading;

public class display {

     public synchronized void wish(String name)
     {
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

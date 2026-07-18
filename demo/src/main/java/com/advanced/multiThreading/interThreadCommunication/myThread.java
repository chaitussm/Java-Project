package com.advanced.multiThreading.interThreadCommunication;

public class myThread extends Thread{

      int total = 0;
    public void run()
    {
       synchronized(this)
       {
          System.out.println("Child thread starts calculation");
          for(int i = 1 ; i<=100; i++)
          {
            total = total + i;
          }

          this.notify(); //notify() method will notify the waiting thread to wake up and continue its execution 
       }
    }
    
}

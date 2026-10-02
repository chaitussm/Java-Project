package com.advanced.multiThreading.concurrentPackage.exampleOne;

public class myThread extends Thread{

    display d ; 

    String name;
    
    myThread(display d, String name)
    {
        this.d = d; 
        this.name = name;
    }
    
    public void run()
    {
        d.wish(name);


    }




    
}

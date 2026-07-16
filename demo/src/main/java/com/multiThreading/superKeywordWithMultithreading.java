package com.multiThreading;


public class superKeywordWithMultithreading  {

    /* Calling the start() method of the Thread class using super keyword

IllegalThreadStateException occurs because you are calling super.start() from inside run().


                
super.start() tries to start the same thread again
Thread.start() may only be called once per thread object
calling it a second time throws IllegalThreadStateException*/

    

    public static void main(String[] args) {
        myThread thread = new myThread();
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }


    
}

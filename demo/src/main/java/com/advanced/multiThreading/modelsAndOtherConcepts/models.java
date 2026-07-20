package com.advanced.multiThreading.modelsAndOtherConcepts;

public class models {

    /*models are 
    1.Green thread model : Thread which is managed completely by JVM without taking OS resources and available only for Solaris 
    2.Native OS model : Thread which is managed by the operating system and takes up OS resources 
    example 
    3.stop() : its is depricated method and it is presnt in t.stop()
    */


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

       
        t1.start();
        System.out.println("End of main thread");
        //t1.stop(); // Deprecated method to stop the thread
       
    }

    
}

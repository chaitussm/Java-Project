package com.advanced.multiThreading.classlevelLock;

public class democlass {

    public static synchronized void wish(String name){

        for(int i = 1; i <= 5; i++) {
            System.out.print("Good morning ");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name);
        }

    }
    
}

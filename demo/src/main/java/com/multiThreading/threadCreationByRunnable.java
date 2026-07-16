package com.multiThreading;

public class threadCreationByRunnable implements Runnable {

    /*Among extending Therad class and implementing Runnable Interface , Runnable Interface approach is best 
    to define the therad because it allows the class to extend another class if needed*/

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {
        threadCreationByRunnable runnable = new threadCreationByRunnable();
        /*If we dont pass the object inside below thread class object empty run() inside the thread class will be called*/
        Thread thread = new Thread(runnable);
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
}

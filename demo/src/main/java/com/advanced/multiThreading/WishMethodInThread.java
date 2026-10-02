package com.advanced.multiThreading;

public class WishMethodInThread extends Thread {

    /**
     * This method contains the threaded work.
     * run() calls wish() so the new thread executes the loop.
     */
    public synchronized void wish(String name) {

        for(int i = 1; i <= 5; i++) {
            System.out.println(name + " says: Good morning " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread Name: " + Thread.currentThread().getName());
        }
       
    }

    public static void main(String[] args) {
        WishMethodInThread wishThread = new WishMethodInThread();
        wishThread.wish("Dhoni");
        WishMethodInThread wishThread1 = new WishMethodInThread();
        wishThread1.wish("Kohli");
        wishThread.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}

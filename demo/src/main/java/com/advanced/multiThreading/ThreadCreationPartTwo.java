package com.advanced.multiThreading;

public class ThreadCreationPartTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadCreationPartTwo());
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
}

package com.multiThreading;

public class threadCreationPartOne extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    public static void main(String[] args) {
        threadCreationPartOne thread = new threadCreationPartOne();
        thread.start();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
    
    /*Here output is not same as expected because thread scheduling is non-deterministic 
      Inside therad method 
      1.register this thread with thread scheduler
      2.perform all other mandatory activities
      3.execute the run() method */

}

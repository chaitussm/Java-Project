package com.advanced.multiThreading;

public class executeMainFirstusingJoin {

    public static void main(String[] args) {
        myThreadWithJoin.t1 = Thread.currentThread();
        /*The above line is to invoke the main thread*/
        myThreadWithJoin t = new myThreadWithJoin();
        t.start();

        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }

}
 
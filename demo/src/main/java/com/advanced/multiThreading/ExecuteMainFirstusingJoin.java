package com.advanced.multiThreading;

public class ExecuteMainFirstusingJoin {

    public static void main(String[] args) {
        MyThreadWithJoin.t1 = Thread.currentThread();
        /*The above line is to invoke the main thread*/
        MyThreadWithJoin t = new MyThreadWithJoin();
        t.start();

        for(int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }

}
 
package com.concurrentCollection.copyOnWriteArrayListClass.updationByoneThreadwhileOtherThreadExceution;

import java.util.concurrent.CopyOnWriteArrayList;

public class childThreadBase extends Thread {

    static CopyOnWriteArrayList<String> coal = new CopyOnWriteArrayList<String>();

    @Override
    public void run() {

        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println("Child thread will be updating the collection Object while main thread is running.");

        coal.add("Kunti");
    }

}

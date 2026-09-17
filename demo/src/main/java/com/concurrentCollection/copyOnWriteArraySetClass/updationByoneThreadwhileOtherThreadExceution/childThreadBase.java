package com.concurrentCollection.copyOnWriteArraySetClass.updationByoneThreadwhileOtherThreadExceution;

import java.util.concurrent.CopyOnWriteArraySet;

public class childThreadBase extends Thread {

    static CopyOnWriteArraySet<String> coal = new CopyOnWriteArraySet<String>();

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

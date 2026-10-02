package com.concurrentCollection.concurrentMap.updationByoneThreadDuringOtherThreadExceution;

import java.util.concurrent.ConcurrentHashMap;

public class childBaseThread extends Thread {

    static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {

        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Thread execution logic here
        System.out.println("Child Thread: Updating the map");
        map.put(100, "Arjuna"); // Update the map after the simulated work
    }
}

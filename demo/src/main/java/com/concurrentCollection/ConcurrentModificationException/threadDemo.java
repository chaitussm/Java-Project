package com.concurrentCollection.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;

public class threadDemo extends Thread {

    static ArrayList<String> arraylist = new ArrayList<>();

    @Override
    public void run() {

        try {
            Thread.sleep(1000); // Simulate some work with the shared list
        } catch (InterruptedException e) {

            System.out.println("Child thread was interrupted: " + e.getMessage());
        }

        System.out.println("Child thread is updating the list : ");
        arraylist.add("apple");
    }

    public static void main(String[] args) throws InterruptedException {

        arraylist.add("banana");
        arraylist.add("pomegranate");

        threadDemo t = new threadDemo();
        t.start();// At this 2 threads are there main and child thread

        Iterator<String> iterator = arraylist.iterator();
        while (iterator.hasNext()) {

            String data = iterator.next();
            System.out.println(data);
            Thread.sleep(500); // Simulate some processing time for each element
        }

        System.out.println("Final array list: " + arraylist);

    }

}

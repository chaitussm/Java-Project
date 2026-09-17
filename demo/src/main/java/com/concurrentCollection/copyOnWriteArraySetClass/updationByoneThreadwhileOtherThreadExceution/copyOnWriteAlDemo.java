package com.concurrentCollection.copyOnWriteArraySetClass.updationByoneThreadwhileOtherThreadExceution;

import static com.concurrentCollection.copyOnWriteArraySetClass.updationByoneThreadwhileOtherThreadExceution.childThreadBase.coal;

import java.util.Iterator;

public class copyOnWriteAlDemo {
    public static void main(String[] args) throws InterruptedException {

        coal.add("panduraju");
        coal.add("Maadhri");

        System.out.println("Main thread is running.");

        childThreadBase childThread = new childThreadBase();
        childThread.start();

        Iterator<String> itr = coal.iterator();

        while (itr.hasNext()) {

            String element = (String) itr.next();
            System.out.println("Main Thread is iterating List: " + element);
            Thread.sleep(1000); // Simulate some delay for demonstration purposes
        }

        System.out.println("Main Thread has finished iterating the List." + coal);
    }

}

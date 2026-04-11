package com.objectoriented.accessmodifiers;

public class VolatileModifier {

    // The volatile modifier is used to indicate that a variable's value may be modified by multiple threads.
    // It ensures that changes made to the variable by one thread are immediately visible to other threads.
    // A volatile variable is not cached thread-locally, and all reads and writes go straight to main memory.
    // It is important to use the volatile modifier when you have a variable that is accessed by multiple threads and you want to ensure that all threads see the most up-to-date value of the variable.
    // However, it is important to note that the volatile modifier does not provide atomicity or synchronization, so it should be used with caution in situations where multiple threads are modifying the same variable.

    private volatile boolean running = true;
    private int count = 0;

    public void stop() {
        running = false;
    }

    public void runTask() {
        while (running) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count=" + count);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        VolatileModifier modifier = new VolatileModifier();

        Thread taskThread = new Thread(modifier::runTask, "Task-Thread");
        taskThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        modifier.stop();

        try {
            taskThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final count: " + modifier.getCount());
    }
    
}

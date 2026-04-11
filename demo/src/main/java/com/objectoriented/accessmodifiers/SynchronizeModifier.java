package com.objectoriented.accessmodifiers;

public class SynchronizeModifier {
    
    private int counter = 0;
    
    // The synchronized modifier is used to control access to a particular resource or block of code by multiple threads in a concurrent programming environment.
    // It ensures that only one thread can access the synchronized block of code at a time, preventing
    // race conditions and ensuring thread safety.
    // When a thread enters a synchronized block, it acquires a lock on the object or
    // class that is being synchronized. Other threads that attempt to access the same block of code will be blocked until the lock is released.
    // The synchronized modifier can be applied to methods or blocks of code. When applied to a
    // method, the entire method is synchronized. When applied to a block of code, only that block is synchronized.
    // It is important to use the synchronized modifier judiciously, as it can lead to
    // performance issues if used excessively or inappropriately. It is recommended to synchronize only the critical sections of code that require thread safety, rather than synchronizing entire methods or classes.
    
    public synchronized void incrementCounter() {
        // Critical section: incrementing the shared counter
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }
    
    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        SynchronizeModifier obj = new SynchronizeModifier();
        
        
        // Create multiple threads to demonstrate synchronization
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.incrementCounter();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.incrementCounter();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final counter value: " + obj.getCounter());
    }

    
}

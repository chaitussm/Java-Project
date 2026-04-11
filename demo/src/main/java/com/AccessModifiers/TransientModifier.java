package com.AccessModifiers;

public class TransientModifier {

    // The transient modifier is used to indicate that a field should not be serialized when an object is serialized.
    // When an object is serialized, all of its fields are converted into a byte stream, which can be saved to a file or transmitted over a network. However, if a field is marked as transient, it will not be included in the serialization process.
    // This can be useful for fields that contain sensitive information or for fields that are not necessary to be saved or transmitted.
    // When an object is deserialized, the transient fields will be initialized with their default values (null for objects, 0 for numeric types, false for boolean).
    transient String name = "Transient Modifier";

    private int counter = 0;

    // A proper synchronized method ensures only one thread can enter the method at a time.
    public synchronized void incrementCounter() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        TransientModifier obj = new TransientModifier();

        

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.incrementCounter();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                obj.incrementCounter();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + obj.getCounter());
    }
}
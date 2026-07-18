package com.advanced.multiThreading.starvation;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class starvation {

    /*
     * Simple starvation demo:
     * 1) One shared resource is protected by an unfair lock.
     * 2) A greedy thread keeps acquiring the lock repeatedly.
     * 3) A starved thread tries to acquire the same lock and often fails.
     */

    private static final int GREEDY_ROUNDS = 12;
    private static final int STARVED_ROUNDS = 12;
    private static final int HOLD_TIME_MS = 40;

    static class SharedResource {
        private final ReentrantLock lock = new ReentrantLock(false); // unfair lock

        public boolean tryUse(String name) {
            try {
                if (lock.tryLock(50, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println(name + " acquired the lock");
                        Thread.sleep(HOLD_TIME_MS);
                        System.out.println(name + " released the lock");
                        return true;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(name + " could not acquire the lock");
                    return false;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread greedy = new Thread(() -> {
            for (int i = 0; i < GREEDY_ROUNDS; i++) {
                resource.tryUse("Greedy");
            }
        }, "Greedy");

        Thread starved = new Thread(() -> {
            int failed = 0;
            for (int i = 0; i < STARVED_ROUNDS; i++) {
                if (!resource.tryUse("Starved")) {
                    failed++;
                }
            }
            System.out.println("Starved thread failed " + failed + " times");
        }, "Starved");

        greedy.setPriority(Thread.MAX_PRIORITY);
        starved.setPriority(Thread.MIN_PRIORITY);

        greedy.start();
        starved.start();

        greedy.join();
        starved.join();

        System.out.println("\nExample complete: the starved thread may fail many times while the greedy thread keeps using the lock.");
    }
}

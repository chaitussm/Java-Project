package com.advanced.multiThreading.interThreadCommunication;

public class waitNotifyNotifyAll {

    /*Except wait() notify and notifyAll() methods there no other methods for which lock will be released*/

    private static final Object lock = new Object();
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        // 1. main creates the waiter thread.
        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                // 3. waiter thread enters the lock and prints this line.
                System.out.println("Waiter: lock acquired, calling wait()");
                try {
                    while (!ready) {
                        // 4. waiter calls wait(), releases the lock, and pauses.
                        lock.wait(); //we can use belwo methods also instead of wait() method
                        //lock.wait(0);
                        //lock.wait(0, 0);
                        // 5. after notify, waiter will try to reacquire the lock and continue here.
                    }
                    // 6. after ready becomes true and lock is reacquired, this line prints.
                    System.out.println("Waiter: resumed after notify()");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 2. main creates the notifier thread.
        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                // 8. notifier acquires the lock and prints this line.
                System.out.println("Notifier: lock acquired, setting ready=true");
                // 9. set the shared condition so waiter can continue.
                ready = true;
                // 10. notify wakes one waiting thread, but lock is still held until exit.
                lock.notify();
                System.out.println("Notifier: notify() called, releasing lock");
            }
        });

        // 7. start the waiter thread first.
        waiter.start();
        Thread.sleep(1000); // allow waiter to start and wait
        // 11. start the notifier thread.
        notifier.start();

        // 12. wait for both threads to finish before main exits.
        waiter.join();
        notifier.join();
    }
}

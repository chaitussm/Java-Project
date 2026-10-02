package com.advanced.multiThreading.interThreadCommunication;

public class WaitNotifyNotifyAll {

    /*Except wait() notify and notifyAll() methods there no other methods for which MONITOR_LOCK will be released*/

    private static final Object MONITOR_LOCK = new Object();
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        // 1. main creates the waiter thread.
        Thread waiter = new Thread(() -> {
            synchronized (MONITOR_LOCK) {
                // 3. waiter thread enters the MONITOR_LOCK and prints this line.
                System.out.println("Waiter: MONITOR_LOCK acquired, calling wait()");
                try {
                    while (!ready) {
                        // 4. waiter calls wait(), releases the MONITOR_LOCK, and pauses.
                        MONITOR_LOCK.wait(); //we can use belwo methods also instead of wait() method
                        //MONITOR_LOCK.wait(0);
                        //MONITOR_LOCK.wait(0, 0);
                        // 5. after notify, waiter will try to reacquire the MONITOR_LOCK and continue here.
                    }
                    // 6. after ready becomes true and MONITOR_LOCK is reacquired, this line prints.
                    System.out.println("Waiter: resumed after notify()");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 2. main creates the notifier thread.
        Thread notifier = new Thread(() -> {
            synchronized (MONITOR_LOCK) {
                // 8. notifier acquires the MONITOR_LOCK and prints this line.
                System.out.println("Notifier: MONITOR_LOCK acquired, setting ready=true");
                // 9. set the shared condition so waiter can continue.
                ready = true;
                // 10. notify wakes one waiting thread, but MONITOR_LOCK is still held until exit.
                MONITOR_LOCK.notify();
                System.out.println("Notifier: notify() called, releasing MONITOR_LOCK");
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

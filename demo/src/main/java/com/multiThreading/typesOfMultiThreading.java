package com.multiThreading;

public class typesOfMultiThreading {

    /*
     * Example: multitasking concepts
     *
     * 1. Executing several tasks simultaneously is the concept of multitasking.
     * 2. Process-based and thread-based multitasking are the two main types.
     * 3. Process-based multitasking uses multiple processes without shared memory or resources across programs.
     * 4. Thread-based multitasking uses multiple threads within the same program, sharing memory and resources.
     * 5. The example below demonstrates both thread-based multitasking and a simple process-based example.
     * 6. Importance for the multithreading is to develop multimedia applications, web servers, and real-time systems where multiple tasks need to run concurrently. 
    */

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1: " + i);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2: " + i);
                }
            }
        });

        thread1.start();
        thread2.start();
        mainProcessBased();
    }

    /**
     * Example for process-based multitasking.
     *
     * <ul>
     *   <li>Detects the operating system at runtime.</li>
     *   <li>Uses {@link ProcessBuilder} to start external processes.</li>
     *   <li>On Windows, starts <code>notepad.exe</code> and <code>calc.exe</code>.</li>
     *   <li>On Unix-like systems, runs simple shell commands via <code>bash -c</code>.</li>
     *   <li>Prints the process ID for each started process.</li>
     *   <li>Logs an error if process startup fails.</li>
     * </ul>
     */

    public static void mainProcessBased() {
        String osName = System.getProperty("os.name").toLowerCase();
        Process process1 = null;
        Process process2 = null;

        try {
            if (osName.contains("win")) {
                process1 = new ProcessBuilder("notepad.exe").start();
                process2 = new ProcessBuilder("calc.exe").start();
            } else {
                process1 = new ProcessBuilder("bash", "-c", "sleep 2").start();
                process2 = new ProcessBuilder("bash", "-c", "echo Process 2 running").start();
            }

            if (process1 != null) {
                System.out.println("Started process 1 with PID: " + process1.pid());
            }
            if (process2 != null) {
                System.out.println("Started process 2 with PID: " + process2.pid());
            }
        } catch (Exception e) {
            System.err.println("Failed to start process-based example for OS: " + osName);
            e.printStackTrace();
        }
    }
    
}

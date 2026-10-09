package com.jvmArchitecture.heapMemoryDemo;

public class HeapMemoryDemo {
    
    public static void main(String[] args) {
     
        double memoryUsage = 1024*1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total memory: " + runtime.totalMemory() / memoryUsage + " MB");
        System.out.println("Max memory: " + runtime.maxMemory() / memoryUsage + " MB");
        System.out.println("Consumed memory: " + (runtime.totalMemory() - runtime.freeMemory()) / memoryUsage + " MB");
        System.out.println("Free memory: " + runtime.freeMemory() / memoryUsage + " MB");

        //upgrade max memory using Xmx
        // -Xmx option is used to set the maximum heap size for the JVM. For example, you can run the program with:
        // java -Xmx512m HeapMemoryDemo
        //Upgrade total memory using Xms
        // -Xms option is used to set the initial heap size for the JVM. For example, you can run the program with:
        // java -Xms256m HeapMemoryDemo

    }
}

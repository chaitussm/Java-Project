package com.collection.queue.priorotyQueueBasics;
import java.util.PriorityQueue;
public class PriorityQueueDemo {

    public static void main(String[] args) {
        // Example usage of PriorityBase comparator with initial capacity 15 
        PriorityQueue<String> queue = new PriorityQueue<>(15, new PriorityBase());
        queue.offer("Shyam");
        queue.offer("Ram");
        queue.offer("Geeta");
        System.out.println("PriorityQueue with custom comparator: " + queue);
    }
    
}

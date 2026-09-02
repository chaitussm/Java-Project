package com.collections.collectionBaseClasses;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queueDemo {

    // Dispatches to the requested Queue implementation demo. Unknown/blank type falls back to LinkedList.
    public static void queueCollectionType(String collectionType) {
        switch (collectionType) {
            case "ArrayDeque":
                demonstrateArrayDeque();
                break;
            case "PriorityQueue":
                demonstratePriorityQueue();
                break;
            case "LinkedList":
            default:
                demonstrateLinkedListQueue();
                break;
        }
    }

    // LinkedList as Queue: doubly-linked list. FIFO order preserved; offer/poll at ends are O(1).
    private static void demonstrateLinkedListQueue() {
        System.out.println("===== LinkedList (as Queue) =====");
        CollectionTypeInspector.printTypeInfo(LinkedList.class, Queue.class);
        CollectionTypeInspector.printDefaultInitialCapacity("LinkedList: no capacity concept (node-based; grows/shrinks one node at a time)");
        Queue<String> queue = new LinkedList<>();

        // Basic methods
        queue.offer("Ram");               // offer(E) -> add at tail, O(1), returns false instead of throwing
        queue.offer("Shyam");
        queue.offer("Geeta");
        System.out.println("After offer(): " + queue);

        System.out.println("peek(): " + queue.peek());   // O(1) - look at head without removing, null if empty
        System.out.println("poll(): " + queue.poll());   // O(1) - remove and return head, null if empty
        System.out.println("After poll(): " + queue);

        // Cursor: Iterator - forward-only, traverses head-to-tail (FIFO order)
        System.out.println("Iterator traversal (head-to-tail FIFO order):");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: FIFO insertion order preserved; backed by linked nodes,");
        System.out.println("so offer/poll at the head/tail are fast (O(1)); no sorting or capacity limit.");
    }

    // ArrayDeque: resizable array double-ended queue. Faster than LinkedList for queue/stack use; no capacity limit.
    private static void demonstrateArrayDeque() {
        System.out.println("===== ArrayDeque =====");
        CollectionTypeInspector.printTypeInfo(ArrayDeque.class, Queue.class);
        CollectionTypeInspector.printDefaultInitialCapacity("ArrayDeque: 16 elements (internal array capacity is always kept a power of two)");
        Queue<String> queue = new ArrayDeque<>();

        // Basic methods
        queue.offer("Ram");               // offer(E) -> add at tail, O(1) amortized
        queue.offer("Shyam");
        queue.offer("Geeta");
        System.out.println("After offer(): " + queue);

        System.out.println("peek(): " + queue.peek());   // O(1) - array-index access to the head
        System.out.println("poll(): " + queue.poll());   // O(1) amortized - remove head
        System.out.println("After poll(): " + queue);

        // Cursor: Iterator - forward-only, traverses head-to-tail (FIFO order)
        System.out.println("Iterator traversal (head-to-tail FIFO order):");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: FIFO insertion order preserved; backed by a resizable circular array,");
        System.out.println("so it is generally faster than LinkedList and disallows null elements.");
    }

    // PriorityQueue: binary-heap backed. NOT FIFO order - elements come out by natural order/Comparator priority.
    private static void demonstratePriorityQueue() {
        System.out.println("===== PriorityQueue =====");
        CollectionTypeInspector.printTypeInfo(PriorityQueue.class, Queue.class);
        CollectionTypeInspector.printDefaultInitialCapacity("PriorityQueue: 11 elements (binary heap backing array)");
        Queue<String> queue = new PriorityQueue<>();

        // Basic methods
        queue.offer("Shyam");             // offer(E) -> O(log n), re-heapifies to keep smallest at head
        queue.offer("Ram");
        queue.offer("Geeta");
        System.out.println("After offer() (internal heap array, not insertion order): " + queue);

        System.out.println("peek(): " + queue.peek());   // O(1) - head is always the smallest element
        System.out.println("poll(): " + queue.poll());   // O(log n) - remove smallest, re-heapify
        System.out.println("After poll(): " + queue);

        // Cursor: Iterator - forward-only; traversal order is the internal heap array, NOT priority order
        System.out.println("Iterator traversal (heap array order, not guaranteed priority order):");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println("  " + iterator.next());
        }

        System.out.println("Core characteristic: NO insertion order and NOT FIFO; elements are ordered by natural");
        System.out.println("ordering/Comparator, so offer/poll cost O(log n) versus O(1) for LinkedList/ArrayDeque.");
    }

}

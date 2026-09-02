package com.collections;
import com.collections.collectionBaseClasses.queueDemo; 

public class queueInterface extends queueDemo{
    public static void demonstrateQueue(String collectionType) {
        queueCollectionType("LinkedList");
        queueCollectionType("PriorityQueue");
        queueCollectionType("Deque");
        queueCollectionType("BlockingQueue");
    }
}

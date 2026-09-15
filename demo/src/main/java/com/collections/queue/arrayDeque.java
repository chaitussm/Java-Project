package com.collections.queue;

import com.collections.collectionBaseClasses.CollectionTypeInspector;
import com.collections.collectionBaseClasses.queueDemo;

public class arrayDeque extends queueDemo{

    public static void demonstrateQueue(String collectionType) {
        queueCollectionType(collectionType);
        queueConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateQueue("ArrayDeque");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList", "ArrayDeque", "PriorityQueue");
    }
    
}

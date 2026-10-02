package com.collection.queue;

import com.collection.collectionBaseClasses.CollectionTypeInspector;
import com.collection.collectionBaseClasses.queueDemo;

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

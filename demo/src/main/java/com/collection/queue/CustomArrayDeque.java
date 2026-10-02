package com.collection.queue;

import com.collection.collectionBaseClasses.CollectionTypeInspector;
import com.collection.collectionBaseClasses.QueueDemo;

public class CustomArrayDeque extends QueueDemo{

    public static void demonstrateQueue(String collectionType) {
        queueCollectionType(collectionType);
        queueConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateQueue("CustomArrayDeque");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList", "CustomArrayDeque", "PriorityQueue");
    }
    
}

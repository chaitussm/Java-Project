package com.collection.queue;

import com.collection.collectionBaseClasses.CollectionTypeInspector;
import com.collection.collectionBaseClasses.QueueDemo; 

public class PriroityQueue extends QueueDemo{

    public static void demonstrateQueue(String collectionType) {
        queueCollectionType(collectionType);
        queueConstructors(collectionType);
    }

    public static void main(String[] args) {

        demonstrateQueue("PriorityQueue");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList", "ArrayDeque", "PriorityQueue");
    }
}

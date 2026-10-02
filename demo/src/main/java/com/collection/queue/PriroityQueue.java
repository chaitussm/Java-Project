package com.collection.queue;

import com.collection.collectionBaseClasses.CollectionTypeInspector;
import com.collection.collectionBaseClasses.queueDemo; 

public class priroityQueue extends queueDemo{

    public static void demonstrateQueue(String collectionType) {
        queueCollectionType(collectionType);
        queueConstructors(collectionType);
    }

    public static void main(String[] args) {

        demonstrateQueue("PriorityQueue");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList", "ArrayDeque", "PriorityQueue");
    }
}

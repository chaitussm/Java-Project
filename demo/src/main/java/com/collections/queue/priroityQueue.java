package com.collections.queue;

import com.collections.collectionBaseClasses.CollectionTypeInspector;
import com.collections.collectionBaseClasses.queueDemo; 

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

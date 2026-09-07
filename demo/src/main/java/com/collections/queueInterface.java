package com.collections;

import com.collections.collectionBaseClasses.CollectionTypeInspector;
import com.collections.collectionBaseClasses.queueDemo; 

public class queueInterface extends queueDemo{

    public static void demonstrateQueue(String collectionType) {
        queueCollectionType(collectionType);
        queueConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateQueue("LinkedList");
        demonstrateQueue("ArrayDeque");
        demonstrateQueue("PriorityQueue");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList", "ArrayDeque", "PriorityQueue");
    }
}

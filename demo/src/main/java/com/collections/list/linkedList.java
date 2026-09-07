package com.collections.list;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class linkedList extends listDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("LinkedList");
        CollectionTypeInspector.printDefaultCapacitySummary("LinkedList");
    }
}

package com.collection.list;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomLinkedList extends ListDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("CustomLinkedList");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomLinkedList");
    }
}

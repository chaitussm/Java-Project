package com.collections.list;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class listInterface extends listDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("ArrayList");
        demonstrateList("LinkedList");
        demonstrateList("Vector");
        demonstrateList("Stack");
        CollectionTypeInspector.printDefaultCapacitySummary();
    }
}

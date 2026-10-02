package com.collection.list;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class stackClass extends listDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("Stack");
        CollectionTypeInspector.printDefaultCapacitySummary("Stack");
    }
}

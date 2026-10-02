package com.collection.list;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class arrayList extends listDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("ArrayList");
        CollectionTypeInspector.printDefaultCapacitySummary("ArrayList");

    }
}

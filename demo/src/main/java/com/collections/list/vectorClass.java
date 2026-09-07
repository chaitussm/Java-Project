package com.collections.list;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class vectorClass extends listDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("Vector");
        CollectionTypeInspector.printDefaultCapacitySummary("Vector");
    }
}

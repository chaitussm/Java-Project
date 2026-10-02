package com.collection.list;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class VectorClass extends ListDemo {

    public static void demonstrateList(String collectionType) {
        listCollectionType(collectionType);
        listConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateList("Vector");
        CollectionTypeInspector.printDefaultCapacitySummary("Vector");
    }
}

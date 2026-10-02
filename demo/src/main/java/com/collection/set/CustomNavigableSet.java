package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

// Dedicated launcher for CustomNavigableSet behavior, implemented by TreeSet.
public class CustomNavigableSet extends SetDemo {

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        setComparator(collectionType);
    }

    public static void main(String[] args) {
        demonstrateSet("CustomNavigableSet");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomNavigableSet");
    }
}

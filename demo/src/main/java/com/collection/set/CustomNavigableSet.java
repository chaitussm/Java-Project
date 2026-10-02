package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

// Dedicated launcher for NavigableSet behavior, implemented by TreeSet.
public class navigableSet extends setDemo {

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        setComparator(collectionType);
    }

    public static void main(String[] args) {
        demonstrateSet("NavigableSet");
        CollectionTypeInspector.printDefaultCapacitySummary("NavigableSet");
    }
}

package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomSortedSet extends SetDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("TreeSet") || collectionType.equals("CustomSortedSet")
                || collectionType.equals("NavigableSet")) {
            setComparator(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("CustomSortedSet");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomSortedSet");
    }
}

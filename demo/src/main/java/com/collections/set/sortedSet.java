package com.collections.set;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class sortedSet extends setDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("TreeSet") || collectionType.equals("SortedSet")
                || collectionType.equals("NavigableSet")) {
            setComparator(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("SortedSet");
        CollectionTypeInspector.printDefaultCapacitySummary("SortedSet");
    }
}

package com.collections;

import com.collections.collectionBaseClasses.CollectionTypeInspector;
import com.collections.collectionBaseClasses.setDemo;

public class setInterface extends setDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
    }

    public static void main(String[] args) {
        demonstrateSet("HashSet");
        demonstrateSet("LinkedHashSet");
        demonstrateSet("TreeSet");
        CollectionTypeInspector.printDefaultCapacitySummary();
    }
}

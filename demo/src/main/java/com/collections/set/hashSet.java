package com.collections.set;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class hashSet extends setDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("HashSet") || collectionType.equals("LinkedHashSet")) {
            setLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("HashSet");
        CollectionTypeInspector.printDefaultCapacitySummary("HashSet");
    }
}

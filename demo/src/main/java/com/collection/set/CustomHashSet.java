package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomHashSet extends SetDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("CustomHashSet") || collectionType.equals("LinkedHashSet")) {
            setLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("CustomHashSet");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomHashSet");
    }
}

package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomLinkedHashSet extends SetDemo{

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("HashSet") || collectionType.equals("CustomLinkedHashSet")) {
            setLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("CustomLinkedHashSet");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomLinkedHashSet");
    }
}

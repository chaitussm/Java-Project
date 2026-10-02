package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomTreeSet extends SetDemo {

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("HashSet") || collectionType.equals("LinkedHashSet")) {
            setLoadFactor(collectionType);
        }
        if (collectionType.equals("CustomTreeSet")) {
            setComparator(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("CustomTreeSet");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomTreeSet");
    }
}

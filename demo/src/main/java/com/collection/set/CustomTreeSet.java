package com.collection.set;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class treeSet extends setDemo {

    public static void demonstrateSet(String collectionType) {
        setCollectionType(collectionType);
        setConstructors(collectionType);
        if (collectionType.equals("HashSet") || collectionType.equals("LinkedHashSet")) {
            setLoadFactor(collectionType);
        }
        if (collectionType.equals("TreeSet")) {
            setComparator(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateSet("TreeSet");
        CollectionTypeInspector.printDefaultCapacitySummary("TreeSet");
    }
}

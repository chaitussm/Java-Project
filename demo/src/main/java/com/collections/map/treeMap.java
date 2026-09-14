package com.collections.map;

import com.collections.collectionBaseClasses.CollectionTypeInspector;

public class treeMap extends mapDemo{

    public static void demonstrateMap(String collectionType) {
        mapCollectionType(collectionType);
        mapConstructors(collectionType);
        if (collectionType.equals("HashMap") || collectionType.equals("LinkedHashMap")
                || collectionType.equals("Hashtable")) {
            mapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateMap("TreeMap");
        CollectionTypeInspector.printDefaultCapacitySummary("HashMap", "LinkedHashMap", "TreeMap", "Hashtable");
    }
}

package com.collections;

import com.collections.collectionBaseClasses.CollectionTypeInspector;
import com.collections.collectionBaseClasses.mapDemo;

public class mapInterface extends mapDemo{

    public static void demonstrateMap(String collectionType) {
        mapCollectionType(collectionType);
        mapConstructors(collectionType);
        if (collectionType.equals("HashMap") || collectionType.equals("LinkedHashMap")
                || collectionType.equals("Hashtable")) {
            mapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateMap("HashMap");
        demonstrateMap("LinkedHashMap");
        demonstrateMap("TreeMap");
        demonstrateMap("Hashtable");
        CollectionTypeInspector.printDefaultCapacitySummary("HashMap", "LinkedHashMap", "TreeMap", "Hashtable");
    }
}

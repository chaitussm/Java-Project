package com.collection.map;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomHashMap extends MapDemo{

    public static void demonstrateMap(String collectionType) {
        mapCollectionType(collectionType);
        mapConstructors(collectionType);
        if (collectionType.equals("CustomHashMap") || collectionType.equals("LinkedHashMap")
                || collectionType.equals("Hashtable")) {
            mapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateMap("CustomHashMap");
        CollectionTypeInspector.printDefaultCapacitySummary("CustomHashMap", "LinkedHashMap", "TreeMap", "Hashtable");
    }
}

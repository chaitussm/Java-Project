package com.collection.map;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomLinkedHashMap extends MapDemo{

    public static void demonstrateMap(String collectionType) {
        mapCollectionType(collectionType);
        mapConstructors(collectionType);
        if (collectionType.equals("HashMap") || collectionType.equals("CustomLinkedHashMap")
                || collectionType.equals("Hashtable")) {
            mapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateMap("CustomLinkedHashMap");
        CollectionTypeInspector.printDefaultCapacitySummary("HashMap", "CustomLinkedHashMap", "TreeMap", "Hashtable");
    }
}

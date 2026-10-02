package com.collection.map;

import com.collection.collectionBaseClasses.CollectionTypeInspector;

public class CustomTreeMap extends MapDemo{

    public static void demonstrateMap(String collectionType) {
        mapCollectionType(collectionType);
        mapConstructors(collectionType);
        if (collectionType.equals("HashMap") || collectionType.equals("LinkedHashMap")
                || collectionType.equals("Hashtable")) {
            mapLoadFactor(collectionType);
        }
    }

    public static void main(String[] args) {
        demonstrateMap("CustomTreeMap");
        CollectionTypeInspector.printDefaultCapacitySummary("HashMap", "LinkedHashMap", "CustomTreeMap", "Hashtable");
    }
}

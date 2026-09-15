package com.collections.map.treeMapSorting;

import java.util.TreeMap;

public class defaultNaturalSortingTreeMap {


    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

        treeMap.put(100, "Shiva");
        treeMap.put(250, "Parvathi");
        treeMap.put(200, "Ganesha");
        treeMap.put(150, "Subrahmanya");
        //treeMap.put(null, "Vishnu"); gives null pointer exception because TreeMap does not allow null keys when using natural ordering
        //treeMap.put("", "Vishnu"); gives class cast exception because TreeMap is expecting Integer keys, not String keys

        System.out.println("TreeMap (default natural sorting): " + treeMap);



    }
    
}

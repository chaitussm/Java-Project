package com.collections.map.treeMapSorting;

import java.util.TreeMap;

public class customizedSortingTreeMap {

    public static void main(String[] args) {

        
        TreeMap<Object, String> treeMap = new TreeMap<Object, String>(new customizedBase());

        treeMap.put(100, "Shiva");
        treeMap.put(250, "Parvathi");
        treeMap.put(200, "Ganesha");
        treeMap.put(150, "Subrahmanya");

        System.out.println("TreeMap (customized sorting): " + treeMap);
    }
    
}

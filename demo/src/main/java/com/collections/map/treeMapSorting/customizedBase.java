package com.collections.map.treeMapSorting;

import java.util.Comparator;

public class customizedBase implements Comparator<Object>{


    @Override
    public int compare(Object o1, Object o2) {
        return o2.toString().compareTo(o1.toString());
    }
}

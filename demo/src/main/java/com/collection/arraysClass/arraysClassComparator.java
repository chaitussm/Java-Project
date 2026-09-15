package com.collection.arraysClass;

public class arraysClassComparator implements java.util.Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1);
    }
    
}

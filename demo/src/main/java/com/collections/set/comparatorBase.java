package com.collections.set;

//WAP to insert objects into the TreeSet where the sorting order is 
//descending order
public class comparatorBase implements java.util.Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2.compareTo(i1); // Descending order
    }
}

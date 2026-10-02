package com.collection.set.comparatorConcepts.stringObject;

import java.util.*;

/**
 * WAP to insert objects into the TreeSet where the sorting order is 
 * according to reverse of the alphabetical order.
 * StringObjectTreeSet
*/

public class StringObjectTreeSet {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new StringObjectComparator());
        treeSet.add("Shiva");
        treeSet.add("Vishnu");
        treeSet.add("Brahma");
        System.out.println(treeSet);
    }
    
}

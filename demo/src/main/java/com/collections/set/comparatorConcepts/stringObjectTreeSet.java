package com.collections.set.comparatorConcepts;

import java.util.*;

/**
 * WAP to insert objects into the TreeSet where the sorting order is 
 * according to reverse of the alphabetical order.
 * stringObjectTreeSet
*/

public class stringObjectTreeSet {

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(new stringObjectComparator());
        treeSet.add("Shiva");
        treeSet.add("Vishnu");
        treeSet.add("Brahma");
        System.out.println(treeSet);
    }
    
}

package com.collection.set.comparatorConcepts.stringAndSBObjects;

/**
 * Write a program to insert String and StringBuffer objects into treeset where sorting order is increaing length order 
 * If 2 objects having same length then consider their alphabetical order.
 */

public class stringAndSBObjectsComparator {

    public static void main(String[] args) {
        java.util.TreeSet<Object> treeSet = new java.util.TreeSet<>(new stringAndSBBase());
        
        treeSet.add("apple");
        treeSet.add(new StringBuffer("pear"));
        treeSet.add("R");
        treeSet.add(new StringBuffer("pea"));
        treeSet.add("R");
        treeSet.add("tea");
       
        for (Object obj : treeSet) {
            System.out.println(obj);
        }
       
    }
    
}

package com.collection.set.comparatorConcepts.basicCustomization;
import java.util.TreeSet;
public class TreeSetCutomized {

    public static void main(String[] args) {
       TreeSet<Integer> treeSet = new TreeSet<>(new ComparatorBase());
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        System.out.println(treeSet);
    }
    
    
}

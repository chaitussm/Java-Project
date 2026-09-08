package com.collections.set;
import java.util.TreeSet;
public class treeSetCutomized {

    public static void main(String[] args) {
       TreeSet<Integer> treeSet = new TreeSet<>(new comparatorBase());
        treeSet.add(5);
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(4);
        System.out.println(treeSet);
    }
    
    
}

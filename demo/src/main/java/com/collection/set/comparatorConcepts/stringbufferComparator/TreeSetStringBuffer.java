package com.collection.set.comparatorConcepts.stringbufferComparator;

import java.util.TreeSet;

public class TreeSetStringBuffer {
    public static void main(String[] args) {
        TreeSet<StringBuffer> treeSet = new TreeSet<>(new StringBufferComparator());
        treeSet.add(new StringBuffer("apple"));
        treeSet.add(new StringBuffer("banana"));
        treeSet.add(new StringBuffer("cherry"));

        for (StringBuffer sb : treeSet) {
            System.out.println(sb);
        }
    }
}

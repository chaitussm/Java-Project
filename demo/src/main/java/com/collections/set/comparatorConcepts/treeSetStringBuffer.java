package com.collections.set.comparatorConcepts;

import java.util.Comparator;
import java.util.TreeSet;

public class treeSetStringBuffer {
    public static void main(String[] args) {
        TreeSet<StringBuffer> treeSet = new TreeSet<>(new stringBufferComparator());
        treeSet.add(new StringBuffer("apple"));
        treeSet.add(new StringBuffer("banana"));
        treeSet.add(new StringBuffer("cherry"));

        for (StringBuffer sb : treeSet) {
            System.out.println(sb);
        }
    }
}

package com.collection.arraysClass;

import java.util.Arrays;

public class arraysClassBase {

    public static void methodsOfArraysClass(Object[] array) {

        //sort the array 
        Arrays.sort(array);

        //print the sorted array
        System.out.println(Arrays.toString(array));

        //reverse the array
        Arrays.sort(array, java.util.Collections.reverseOrder());

        //print the reversed array
        System.out.println(Arrays.toString(array));

        //search for an element
        int index = Arrays.binarySearch(array, array[0]);
        System.out.println("Index of " + array[0] + ": " + index);

        //binary Search with comparator
        index = Arrays.binarySearch(array, array[0], new arraysClassComparator());
        System.out.println("Index of " + array[0] + " with comparator: " + index);

        //array to list
        java.util.List<Object> list = Arrays.asList(array);
        System.out.println("Array as list: " + list);
        //list.remove(index); UnsupportedOperationException
        //add an element at index 1
        //list.add(1,new Integer(10));


        //array to set
        java.util.Set<Object> set = new java.util.HashSet<>(Arrays.asList(array));
        System.out.println("Array as set: " + set);

    }

    public static void main(String[] args) {

        Object[] array = {5, 3, 8, 1, 2};
        methodsOfArraysClass(array);

        //create another array
        Object[] anotherArray = {"apple", "banana", "cherry"};
        methodsOfArraysClass(anotherArray);

    }
    
}

package com.collection.collectionsClass.binarySearchMethod;
import java.util.ArrayList;
import java.util.Collections;
public class binarySearchDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("C");
        list.add("N");
        list.add("K");

        //Here Z is not available in the list 
        //iteration starts from A -1 for A, B -2 for B, -3 for c
        //so Z would be inserted at index 3, hence the result is -4
        int indexZ = Collections.binarySearch(list ,"Z");
        System.out.println("Index of Z before sorting: " + indexZ);        
        
        //unpredictable result without passing the comparator
        int indexBeforeSort = Collections.binarySearch(list, "B");
        System.out.println("Index of B before sorting: " + indexBeforeSort);
        
        Collections.sort(list, new binarySearchBase());
        int index = Collections.binarySearch(list, "B", new binarySearchBase());
        System.out.println("Index of B after sorting: " + index);

    }
    
}

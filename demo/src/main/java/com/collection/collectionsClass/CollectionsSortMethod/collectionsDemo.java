package com.collection.collectionsClass.CollectionsSortMethod;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.List;

public class collectionsDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");

        //approach 2 

        //approach 2
       // ArrayList<String> list2 = new ArrayList<>(List.of("A", "B", "C"));

       System.out.println("Before sorting :" + list);
       Collections.sort(list);

      // list.add(null) not allowed as it will throw NullPointerException during sorting
      //list.add(new Integer(10)) not allowed as it will throw ClassCastException during sorting hetereogenous elements not allowed
       System.out.println("After sorting :" + list);

       //with compartor based 
       Collections.sort(list, new customizedCollectionBase());
       System.out.println("After custom sorting :" + list);

       //reverse the list
       Collections.reverse(list);
       System.out.println("After reversing :" + list);

    }
    
}

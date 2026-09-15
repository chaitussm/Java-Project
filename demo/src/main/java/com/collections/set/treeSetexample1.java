package com.collections.set;
import java.util.*;
public class treeSetexample1 {

    public static void main(String[] args) {


        TreeSet<String> t = new TreeSet<String>();
         
        /*as TreeSet only accepts elements that are comparable
        only String objects are comparable StringBuilder Objects are not 
        comparable
        */
        //t.add(new StringBuilder("A"));
        //t.add(new StringBuilder("B"));

        t.add("Z");
        t.add("K");
        t.add("C");

        System.out.println(t);



    }
    
}

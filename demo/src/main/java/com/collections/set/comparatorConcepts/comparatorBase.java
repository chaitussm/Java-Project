package com.collections.set.comparatorConcepts;

/** WAP to insert objects into the TreeSet where the sorting order is 
 * descending order
 * refer the screenshot with name comparatorConcept.png in 
 * ScreenShots of Java Concepts folder
 */

public class comparatorBase implements java.util.Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2.compareTo(i1); // Descending order

        /*approach 2 
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;

        if(i1 < i2)
            return 1;
        else if(i1 > i2)
            return -1;
        else
            return 0;
          */

        /*approach 3 
         return i2.compareTo(i1);
         approach 4 
         return +1;
         [insertion order] output
         return -1
         reverse of insertion order output
         return 0; // default case
         output only the first element inserted*/
    }
}

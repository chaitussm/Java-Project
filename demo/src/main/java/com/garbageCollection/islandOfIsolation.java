package com.garbageCollection;

public class islandOfIsolation {

    islandOfIsolation i ; 

  

    public static void main(String[] args) {

        islandOfIsolation obj1 = new islandOfIsolation();
        islandOfIsolation obj2 = new islandOfIsolation();
        islandOfIsolation obj3 = new islandOfIsolation();
        
        obj1.i = obj2;
        obj2.i = obj3;
        obj3.i = obj1;

        //Until now obj1, obj2, and obj3 form a circular reference,no object is eligible for garbage collection.

        obj1 = null;
        obj2 = null;
        obj3 = null;

        // Now the circularly referenced objects are eligible for garbage collection as they are no longer reachable from any live thread.
    }
}

package com.advanced.garbageCollection;

public class IslandOfIsolation {

    IslandOfIsolation i ; 

  

    public static void main(String[] args) {

        IslandOfIsolation obj1 = new IslandOfIsolation();
        IslandOfIsolation obj2 = new IslandOfIsolation();
        IslandOfIsolation obj3 = new IslandOfIsolation();
        
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

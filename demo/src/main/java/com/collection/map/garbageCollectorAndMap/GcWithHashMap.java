package com.collection.map.garbageCollectorAndMap;

import java.util.HashMap;

public class GcWithHashMap {

    /**
     * In the case of a HashMap, eventhough object doesnt have anmy reference, it is not eligibale for gc if it is associated with HashMap 
     * i.e HashMap dominates garbage collector 
     * But in the case of a WeakHashMap, if object doesnt contain any references it is eligibel for gc eventhough object associated with weakHashMap
     * i.e garbage collector dominates wekHasp (WeakHashMap)
     */

    public static void main(String[] args) throws Exception  {
        
        HashMap<GarbageCollectorWithMap, String> gcmap = new HashMap<GarbageCollectorWithMap, String>();
        GarbageCollectorWithMap instance = new GarbageCollectorWithMap();
        gcmap.put(instance, "durga");
        System.out.println("Before garbage collector:" + gcmap);
        instance = null; // Make the instance eligible for garbage collection
        System.gc();
        Thread.sleep(1000); // Give the garbage collector some time to run
        System.out.println("After garbage collector:" + gcmap);
    }
    
}

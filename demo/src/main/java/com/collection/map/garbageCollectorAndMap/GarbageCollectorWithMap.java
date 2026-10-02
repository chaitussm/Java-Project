package com.collection.map.garbageCollectorAndMap;

public class GarbageCollectorWithMap {
   
    public String toString()
    {
        return "GarbageCollectorWithMap instance";
    }

    public void finalize() {
        System.out.println("GarbageCollectorWithMap instance is being garbage collected");
    }

}

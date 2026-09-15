package com.collection.map.garbageCollectorAndMap;

public class garbageCollectorWithMap {
   
    public String toString()
    {
        return "garbageCollectorWithMap instance";
    }

    public void finalize() {
        System.out.println("garbageCollectorWithMap instance is being garbage collected");
    }

}

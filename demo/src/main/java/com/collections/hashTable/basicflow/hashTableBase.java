package com.collections.hashTable.basicflow;

public class hashTableBase {

    int i ; 

    hashTableBase(int i)
    {
        this.i = i;
    }

    //overriding the hashcode() method 
    @Override
    public int hashCode() {
        
        return i;
    }

    //overriding the toString() method
    @Override
    public String toString() {
       
        return i + "";
    }
    
}

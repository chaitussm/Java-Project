package com.collection.hashTable.basicflow;

public class HashTableBase {

    int i ; 

    HashTableBase(int i)
    {
        this.i = i;
    }

    //overriding the hashcode() method 
    @Override
    public int hashCode() {
        
        return i;
    }

    //overriding the equals() method to stay consistent with hashCode()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTableBase)) {
            return false;
        }
        HashTableBase other = (HashTableBase) obj;
        return this.i == other.i;
    }

    //overriding the toString() method
    @Override
    public String toString() {
       
        return i + "";
    }
    
}

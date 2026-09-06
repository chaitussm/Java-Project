package com.collections.list;

import java.util.*;
import java.io.*;
public class internalProcessInCollections implements Cloneable, Serializable, RandomAccess {
    //ArrayList and Vector classes only uses the RandomAccess

    private ArrayList<String> data = new ArrayList<>();

    // demonstrates Cloneable: creates a shallow copy of this object
    public void demonstrateCloneable() throws CloneNotSupportedException {
        data.add("cloneable-item");
        internalProcessInCollections clone = (internalProcessInCollections) super.clone();
        System.out.println("Original data: " + data);
        System.out.println("Cloned data: " + clone.data);
    }

    // demonstrates Serializable: writes this object to a file and reads it back
    public void demonstrateSerializable() throws java.io.IOException, ClassNotFoundException {
        data.add("serializable-item");
        String fileName = "internalProcessInCollections.ser";
        try (java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(fileName))) {
            out.writeObject(this);
        }
        try (java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream(fileName))) {
            internalProcessInCollections restored = (internalProcessInCollections) in.readObject();
            System.out.println("Restored data: " + restored.data);
        }
    }

    // demonstrates RandomAccess: marks a List implementation as supporting fast, constant-time indexed access
    public void demonstrateRandomAccess() {
        data.add("randomAccess-item");
        if (data instanceof RandomAccess) {
            System.out.println("ArrayList supports RandomAccess, safe to use indexed for-loop");
            for (int i = 0; i < data.size(); i++) {
                System.out.println("Element at index " + i + ": " + data.get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        internalProcessInCollections processor = new internalProcessInCollections();
        processor.demonstrateCloneable();
        processor.demonstrateSerializable();
        processor.demonstrateRandomAccess();
    }
}

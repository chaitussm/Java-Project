package com.advanced.serialization.objectGraphs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.advanced.serialization.serializeBase;

class dog implements Serializable{

    private static final long serialVersionUID = 1L;

    cat c = new cat();
}

class cat implements Serializable
{
    private static final long serialVersionUID = 1L;
    rat r = new rat();
}

class rat implements Serializable
{
    private static final long serialVersionUID = 1L;
    int j = 20;
}

public class objectGraphBasics extends serializeBase{

    // Docs: docs/concepts/serialization/objectGraphBasics.md (line 1)

    public static void main(String[] args) throws Exception
    {
        dog d = new dog();

         // Store the name of the file that will contain the serialized object.
        // Build the path inside sample-data/serialization for the serialized object file.
        String filename = sampleDataPath("serialization", "objectGraph.ser").toString();

         // Create the object whose state will be written to the serialization file.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(d);
        }
        //deserialize the object 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // readObject() restores dog and all objects reachable from it.
            dog d1 = (dog) ois.readObject();
            System.out.println("Restored rat value: " + d1.c.r.j);
        }



    }
    
}

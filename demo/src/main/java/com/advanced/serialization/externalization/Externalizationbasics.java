package com.advanced.serialization.externalization;

import java.io.*;

import com.advanced.serialization.serializeBase;

public class externalizationbasics extends serializeBase implements Externalizable  {

     // Docs: docs/concepts/serialization/externalizationbasics.md (line 1)


    String name;
    int number;
    int age;

    public externalizationbasics(String name , int number , int age) {
        this.name = name;
        this.number = number;
        this.age = age;
        System.out.println("Parameterized constructor");
    }
    
    public externalizationbasics() {
        System.out.println("Default constructor");
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        number = in.readInt();
        age = in.readInt();
    }

    //It will executed automatically at the time of serialization
    //within this method we can write the logic to serialize the object to save the required variables to the file
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(number);
        out.writeInt(age);
    }

    public static void main(String[] args) {
        externalizationbasics eb = new externalizationbasics("durga", 123, 25);
        String filename = sampleDataPath("serialization", "externalization.ser").toString();

        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(eb);
        }

        catch (Exception e) {
            System.out.println("Unable to fetch the file " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            externalizationbasics eb2 = (externalizationbasics) ois.readObject();
            System.out.println(eb2.name + "-----" + eb2.number + "-----" + eb2.age);
        }

        catch (Exception e) {
            System.out.println("Unable to deserialize :" + e.getMessage());
        }
    }

}

   


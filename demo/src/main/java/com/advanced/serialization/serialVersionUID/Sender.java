package com.advanced.serialization.serialVersionUID;

import java.io.*;

import com.advanced.serialization.serializeBase;

public class sender extends serializeBase{

    public static void main(String[] args) {

        dog1 d1 = new dog1();

        String filename = sampleDataPath("serialization","serialVersionUID.ser" ).toString();

        try( FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(d1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

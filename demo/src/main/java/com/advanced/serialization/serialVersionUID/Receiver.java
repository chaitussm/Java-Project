package com.advanced.serialization.serialVersionUID;
import java.io.*;
import com.advanced.serialization.SerializeBase;
/**
 * Docs: docs/concepts/serialization/SerialVersionUID.md (Part 1) 
 * Docs: docs/concepts/serialization/SerialVersionUID.md (Part 4)
 */

public class Receiver extends SerializeBase{

    public static void main(String[] args) {

        String filename = sampleDataPath("serialization","serialVersionUID.ser" ).toString();

        try( FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Dog1 d2 = (Dog1) ois.readObject();

            System.out.println(d2.i + "====" + d2.j);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

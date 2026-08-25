package com.advanced.serialization.inheritanceSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.advanced.serialization.serializeBase;

class engine implements Serializable
{
     int rpm = 100;
}

class tata extends engine
{
     int cc = 20; 
}
public class inheritanceSerOne extends serializeBase{

    // Docs: docs/concepts/serialization/inheritanceSerializationbasics.md (Part 1, line 13)
    public static void main(String[] args)
    {

        tata a1 = new tata();

        String filename = sampleDataPath("serialization","engine.ser").toString();


          try( FileOutputStream fos = new FileOutputStream(filename);

           ObjectOutputStream oos = new ObjectOutputStream(fos);)
          {
            oos.writeObject(a1);
          }

          catch(Exception e)
          {
             System.out.println("Unable to fetch the file " + e.getMessage());
          }

          try(FileInputStream fis = new FileInputStream(filename);
              ObjectInputStream ois = new ObjectInputStream(fis);)
              {
                 tata a2 = (tata)ois.readObject();
                 
                 System.out.println(a2.rpm + "-----" + a2.cc);
              }

        catch(Exception e)
        {
            System.out.println("Unable to deserialize :" + e.getMessage());
        }
    }


    }



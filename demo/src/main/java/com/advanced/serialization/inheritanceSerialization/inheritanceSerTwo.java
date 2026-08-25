package com.advanced.serialization.inheritanceSerialization;


import java.io.Serializable;

import com.advanced.serialization.serializeBase;

import java.io.*;


class protein 
{
    int proteinContent = 25;

    protein()
    {
        System.out.println("protein class constructor");
    }
}

class concentrate extends protein implements Serializable
{
     int blendContent = 20; 

     concentrate()
     {
         System.out.println("concentrate class constructor");
     }

}

public class inheritanceSerTwo extends serializeBase{

    // Docs: docs/concepts/serialization/inheritanceSerializationbasics.md (Part 2, line 160)

    public static void main(String[] args) throws Exception
    {
        concentrate co = new concentrate();

        co.proteinContent = 100;
        co.blendContent = 200;

        String filename = sampleDataPath("serialization","concentrate.ser").toString();

          try( FileOutputStream fos = new FileOutputStream(filename);

           ObjectOutputStream oos = new ObjectOutputStream(fos);)
          {
            oos.writeObject(co);
          }

          catch(Exception e)
          {
             System.out.println("Unable to fetch the file " + e.getMessage());
          }

          try(FileInputStream fis = new FileInputStream(filename);
              ObjectInputStream ois = new ObjectInputStream(fis);)
              {
                 concentrate co2 = (concentrate)ois.readObject();
                 
                 System.out.println(co2.proteinContent + "-----" + co2.blendContent);
              }

        catch(Exception e)
        {
            System.out.println("Unable to deserialize :" + e.getMessage());
        }
    }
    
}

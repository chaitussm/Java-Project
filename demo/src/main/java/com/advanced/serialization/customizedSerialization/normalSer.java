package com.advanced.serialization.customizedSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.advanced.serialization.serializeBase;

class normalAccount implements Serializable{

    String username = "Shiva";
    transient String password = "Sati";

}

public class normalSer extends serializeBase{
    
    /*
     *
     * During default serialization there may be a chance of loss of information because of transient keyword 
     * 
     */

    public static void main(String[] args) 
    {
           
          normalAccount a1 = new normalAccount();

          String filename = sampleDataPath("serialization","custmDemo,ser").toString();

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
                 normalAccount a2 = (normalAccount)ois.readObject();
                 
                 System.out.println(a2.username + "-----" + a2.password);
              }

        catch(Exception e)
        {
            System.out.println("Unable to deserialize :" + e.getMessage());
        }
    }

}

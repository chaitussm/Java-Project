package com.advanced.serialization.customizedSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.advanced.serialization.serializeBase;

class account extends serializeBase {

    String username = "Rama";

    transient String password = "Sita";


    private void writeObject(ObjectOutputStream os) 
    {
        try{ os.defaultWriteObject();

            String encryptedText = encryptPwd(password);
            System.out.println("Encrypted (Base64): " + encryptedText);
            os.writeObject(encryptedText);
           }
        catch(Exception e)
        {
            System.out.println("Unable to serialize : " + e.getMessage());
        }
    }

    private void readObject(ObjectInputStream is) 
    {
        try{
             is.defaultReadObject();

             String encryptedpwd = (String)is.readObject();

             password = decryptPwd(encryptedpwd);

           }

        catch(Exception e)
        {
            System.out.println("Unable to deserialize :" + e.getMessage());
        }

    }
}

public class customizedSer extends serializeBase{

    // Docs: docs/concepts/serialization/customizedSer.md (Part 1, line 1)
    public static void main(String[] args)
    {
        account a1 = new account();

        String filename = sampleDataPath("serialization","custom,ser").toString();

        try(
            FileOutputStream fos = new FileOutputStream(filename);

            ObjectOutputStream oos = new ObjectOutputStream(fos))
            {
                oos.writeObject(a1);
            }

        catch(Exception e)
        {
             System.out.println("Unable to serialize :" + e.getMessage());
        }

        try{
             FileInputStream fos = new FileInputStream(filename);

             try (ObjectInputStream ois = new ObjectInputStream(fos)) {
                 account a2 = (account)ois.readObject();

                 System.out.println(a2.username + "===" + a2.password);
             }
        }

         catch(Exception e)
        {
             System.out.println("Unable to deserialize :" + e.getMessage());
        }




    }
}

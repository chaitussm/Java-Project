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

    /*
     *
     * We can implement customized serialization by using the following 2 methods 
     * private void writeObject(ObjectOuptuStream os) throws Exception 
     * This method will be executed automatically at the time of serialization, hence at the time of serialization 
     * if we want to perform any activity we have to define that in this method only 
     * private void readObject(ObjectInputStream is) throws Exception
     * This method will be executed automatically at the time of deserialization, hence at the time of deserialization 
     * if we want to perform any activity we have to define that in this method only
     * NOTE: the above methods are call back methods because these are executed automatically by the JVM 
     * while performing the required object serialization we have do extra work in the corresponding class we have to 
     * define above methods
     * example : while performing account Object serialization if we required to extra work in the account class 
     * we have to define above methods
     * 
     */
    
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

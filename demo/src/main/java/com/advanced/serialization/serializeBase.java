package com.advanced.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Base64;


import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

// Docs: docs/concepts/serialization/serializationBasics.md (line 1)
public class serializeBase extends fileBasicMethods implements Serializable {

    int i = 10;

    int j = 20;

    transient int k = 40;

    transient static int x = 30;

    // final + transient: not reassignable, and never written to the serialized file (restored as 0).
    transient final int m = 15;



       // Converts the serializeBase object into bytes and saves those bytes in the specified file.
    // The file parameter contains the path or name of the destination file.
    public void serialize(String file)
    {
        // Create or replace the destination file and prepare it to receive bytes.
        try( FileOutputStream fos = new FileOutputStream(file);
              // Add Java's object-stream format on top of the file output stream.
              ObjectOutputStream oos = new ObjectOutputStream(fos);)
          {
              // Convert sb and its field values into bytes and write them to the file.
              oos.writeObject(this);
          }
         
        // Handle problems such as an invalid path or a file that cannot be opened.
        catch(IOException e) 
        {
            System.out.println("No file is available");
        }
    } 

    // The file parameter must point to a file previously created by serialize().
    public void deserialize(String file)
    {
        // Open the file as a byte stream and wrap it with an object-aware stream.
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the binary data and rebuild the object saved by serialize().
            // readObject() returns Object, so cast it to the expected base type.
            serializeBase restoredObject = (serializeBase) ois.readObject();

            // Store each category separately so the final output is easy to read.
            StringBuilder normalFields = new StringBuilder();
            StringBuilder transientFields = new StringBuilder();
            StringBuilder staticFields = new StringBuilder();
            StringBuilder finalFields = new StringBuilder();

            // Begin with the actual restored class, which may be a child topic class.
            Class<?> currentClass = restoredObject.getClass();

            // Continue through each parent class until java.lang.Object is reached.
            while (currentClass != null && currentClass != Object.class) {
                // getDeclaredFields() returns fields declared in this class only.
                for (Field field : currentClass.getDeclaredFields()) {
                    // Allow reflection to read private, protected, and package fields.
                    field.setAccessible(true);

                    // Get the flags that describe this field, such as static or transient.
                    int modifiers = field.getModifiers();

                    // Static fields belong to the class, so they are not object state.
                    // Passing null is correct because a static value needs no object.
                    if (Modifier.isStatic(modifiers)) {
                        staticFields.append("  ").append(field.getName()).append(" = ")
                                .append(field.get(null)).append(System.lineSeparator());
                    } 
                        // A final transient field follows both rules: final prevents
                        // reassignment, but transient prevents its value being saved.
                        // Therefore m is restored with the default int value, 0.
                        else if (Modifier.isTransient(modifiers) && Modifier.isFinal(modifiers)) {
                        transientFields.append("  ").append(field.getName()).append(" = ")
                                .append(field.get(restoredObject)).append(System.lineSeparator());
                        finalFields.append("  ").append(field.getName()).append(" = ")
                            .append(field.get(restoredObject)).append(System.lineSeparator());
                        // Other transient fields are skipped during serialization.
                        } else if (Modifier.isTransient(modifiers)) {
                        transientFields.append("  ").append(field.getName()).append(" = ")
                            .append(field.get(restoredObject)).append(System.lineSeparator());
                        // A final non-transient field is serialized normally and also listed as final.
                        } else if (Modifier.isFinal(modifiers)) {
                        normalFields.append("  ").append(field.getName()).append(" = ")
                            .append(field.get(restoredObject)).append(System.lineSeparator());
                        finalFields.append("  ").append(field.getName()).append(" = ")
                            .append(field.get(restoredObject)).append(System.lineSeparator());
                    // Other instance fields are normal fields restored from the file.
                    } else {
                        normalFields.append("  ").append(field.getName()).append(" = ")
                                .append(field.get(restoredObject)).append(System.lineSeparator());
                    }
                }

                // Move from the current class to its parent class.
                currentClass = currentClass.getSuperclass();
            }

            // Print normal fields and their values restored from the serialized file.
            System.out.println("Normal serialized fields:");
            System.out.print(normalFields);
            // Print transient fields and show their post-deserialization values.
            System.out.println("Transient fields (not restored from the file):");
            System.out.print(transientFields);
            // Print static fields, which come from the current class, not the file.
            System.out.println("Static fields (not part of object state):");
            System.out.print(staticFields);
            // Print final fields separately; final describes reassignment, not serialization.
            System.out.println("Final fields:");
            System.out.print(finalFields);
        }

        // Handle missing files, invalid serialized data, or reflection problems.
        catch(Exception e )
        {
            System.out.println("No file is available");
        }
    }

    // Displays the exact absolute path where the serialization file is located.
    // An absolute path starts from the computer's root directory.
    public void checkSerializationFileLocation(String file)
    {
        // Create a File object representing the supplied relative or absolute path.
        File serializationFile = new File(file);
        // Convert the path into its complete location and print it.
        System.out.println("Serialization file location: "
                + serializationFile.getAbsoluteFile());
    }

    // Checks whether the path exists and represents a regular file.
    // This confirms that serialization created a usable file.
    public void checkSerializationFileCreated(String file)
    {
        // Represent the expected serialized file as a File object.
        File serializationFile = new File(file);
        // exists() checks presence; isFile() confirms it is a file, not a directory.
        if (serializationFile.exists() && serializationFile.isFile()) {
            System.out.println("Serialization file was created successfully.");
        } else {
            System.out.println("Serialization file was not created.");
        }
    }

    // V2 writes the current object and lets the caller handle any I/O failure.
    // The output stream remains inside this method and is closed automatically.
    public void serializeV2(String file) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file))) {
            oos.writeObject(this);
        }
    }

    // V2 reads the serialized object and returns it instead of only printing it.
    // The generic type allows a child serialization class to receive its own type.
    public <T extends serializeBase> T deserializeV2(String file)
            throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            T restoredObject = (T) ois.readObject();
            return restoredObject;
        }
    }
    

    public static String  encryptPwd(String password)
    {
        // 1. "Encrypt" (Encode)
        String encodedText = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println("Encoded: " + encodedText);

        return encodedText;
    }
    
    public static String decryptPwd(String encodedText)
    {
        // 2. "Decrypt" (Decode)
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        String decodedText = new String(decodedBytes);
        System.out.println("Decoded: " + decodedText); 

        return decodedText;
    }
}

         
    


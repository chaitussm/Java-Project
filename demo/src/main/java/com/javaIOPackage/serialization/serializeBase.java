package com.javaIOPackage.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.*;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class serializeBase extends fileBasicMethods implements Serializable {

    int i = 10;

    int j = 20;

    transient int k = 40;

    transient static int x = 30;

    /*
     * This field uses two independent modifiers:
     *
     * transient - do not save this field's value in the serialized file.
     * final     - do not allow this field to be assigned a new value after
     *             its initialization.
     *
     * Therefore, final does not make a field serializable. The transient rule
     * still wins for file storage: m = 15 is not written to the file. When the
     * object is deserialized, Java gives this int field its default value, 0.
     * The combination is legal and useful when a value must be fixed during
     * normal object life but must never be stored in serialized data.
     */
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

    /*
     * Deserialization is the reverse of serialization. It reads the binary bytes
     * from the file and rebuilds the Java object in memory.
     *
     * The filename extension is not used to identify the data format. The file
     * must contain bytes written by ObjectOutputStream, regardless of whether
     * its name ends with .ser, .dat, .bin, .object, or another extension.
     *
     * This method also demonstrates an important serialization rule:
     * normal fields are restored, transient fields are not restored, and static
     * fields are not part of the object's serialized state.
     *
     * The old condition `this.i == restoredObject.i` was not suitable here.
     * Comparing values cannot identify a field's type. Reflection modifiers are
     * used instead to determine whether a field is normal, transient, or static.
     *
     * The complete class hierarchy is inspected because a topic class such as
     * transientKeyword may inherit its fields from serializeBase. Checking only
     * the child class would miss those inherited fields.
     */
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
                    // Transient fields are skipped during serialization.
                    // An int transient field therefore returns to its default value, 0.
                    else if (Modifier.isTransient(modifiers)) {
                        transientFields.append("  ").append(field.getName()).append(" = ")
                                .append(field.get(restoredObject)).append(System.lineSeparator());
                        // A final transient field, such as m, follows both rules:
                        // final prevents reassignment, while transient prevents saving its value.
                        if (Modifier.isFinal(modifiers)) {
                            finalFields.append("  ").append(field.getName()).append(" = ")
                                    .append(field.get(restoredObject)).append(System.lineSeparator());
                        }
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
    
}

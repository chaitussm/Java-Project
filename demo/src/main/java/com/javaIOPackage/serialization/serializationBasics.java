package com.javaIOPackage.serialization;

import java.io.*;
import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

// This class can be serialized because it implements Serializable.
// It also inherits the shared sampleDataPath() method from fileBasicMethods.
public class serializationBasics extends fileBasicMethods implements Serializable{

    // This object contains the state that will be saved and restored.
    serializeBase sb = new serializeBase();

    /*
     * Serialization is the process of preserving an object's state as bytes.
     * ObjectOutputStream writes those bytes through FileOutputStream into a file.
     *
     * Deserialization is the reverse process: ObjectInputStream reads the bytes
     * through FileInputStream and rebuilds the object in Java memory.
     *
     * Only objects whose classes implement Serializable can be serialized.
    * The .ser extension is a useful naming convention, not a requirement.
    * Common extensions for serialized files are:
    * .ser      - standard Java serialized-object convention
    * .dat      - general data-file convention
    * .bin      - binary-file convention
    * .object   - serialized-object description
    * .ser.gz   - serialized data compressed with GZIP
    *
    * Any extension can work because Java identifies the format from the stream
    * data, not from the filename. The same serialized file must be read back by
    * ObjectInputStream during deserialization.
    * If we trying to serialize a non serializable object then we will get run-time exception saying 
    * NotSerializableException
     */
    
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
              oos.writeObject(sb);
          }
         
        // Handle problems such as an invalid path or a file that cannot be opened.
        catch(IOException e) 
        {
            System.out.println("No file is available");
        }

    } 

    // Reads the serialized bytes from the specified file and rebuilds the original object.
    // The file parameter must point to a file previously created by serialize().
    public void deserialize(String file)
    {
            // Open the serialized file and prepare a stream that understands Java objects.
         try(FileInputStream fis = new FileInputStream(file);
              ObjectInputStream ois = new ObjectInputStream(fis);)
            {
                 // Read the bytes and reconstruct the original serializeBase object.
                serializeBase sb1 = (serializeBase)ois.readObject(); 

                 // Display the values restored from the serialized object.
                System.out.println(sb1.i + "=====" + sb1.j);
            }

        // Handle missing files or invalid serialized data.
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

    // Starts the example: serialize the object, inspect the file, and deserialize it.
    public static void main(String[] args)
    {
        // Store the name of the file that will contain the serialized object.
        // Build the path inside sample-data/serialization for the serialized object file.
        String filename = sampleDataPath("serialization", "fileObject.ser").toString();

        // Create the object whose state will be written to the serialization file.
        serializationBasics sb = new serializationBasics();

        // Save the object as bytes in sample-data/serialization/fileObject.ser.
        sb.serialize(filename);
        // Display the exact location of the generated file.
        sb.checkSerializationFileLocation(filename);
        // Confirm that serialization created the expected file.
        sb.checkSerializationFileCreated(filename);
        // Read the bytes and reconstruct the object from the same file.
        sb.deserialize(filename);
    }

    /*
     * COMPLETE EXECUTION SUMMARY
     *
     * 1. The serializeBase object contains the values that we want to save.
     *
     * 2. The filename variable points to:
     *    demo/sample-data/serialization/fileObject.ser
     *
     * 3. serialize() creates the file and uses ObjectOutputStream to convert
     *    the serializeBase object into Java's binary serialized format.
     *
     * 4. The .ser extension is only a naming convention. It is not compulsory.
     *    Other possible extensions are .dat, .bin, .object, and .ser.gz.
     *    The extension does not control serialization; the stream data does.
     *
     * 5. checkSerializationFileLocation() prints the file's exact absolute path.
     *
     * 6. checkSerializationFileCreated() verifies two things:
     *    exists() confirms that something is present at the path, and
     *    isFile() confirms that the path refers to a regular file.
     *
     * 7. The .ser file may look empty or unreadable in a normal text editor.
     *    This does not mean that it is empty. It contains binary object data,
     *    not ordinary human-readable text.
     *
     * 8. deserialize() uses ObjectInputStream to read the binary data and
     *    rebuild the serializeBase object in Java memory.
     *
     * 9. The restored i and j values are printed after deserialization.
     *    Therefore, output such as 10=====20 proves that the file contains
     *    valid serialized data and that the object was restored successfully.
     */
}

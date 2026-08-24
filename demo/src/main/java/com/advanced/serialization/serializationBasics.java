package com.advanced.serialization;

// This class can be serialized because it implements Serializable.
// It also inherits the shared sampleDataPath() method from fileBasicMethods.
public class serializationBasics extends serializeBase {

    // This object contains the state that will be saved and restored.
    //serializeBase sb = new serializeBase();

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

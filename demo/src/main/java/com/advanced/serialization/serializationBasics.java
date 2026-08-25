package com.advanced.serialization;

// This class can be serialized because it implements Serializable.
// It also inherits the shared sampleDataPath() method from fileBasicMethods.
// Docs: docs/concepts/serialization/serializationBasics.md (line 1)
public class serializationBasics extends serializeBase {

    // This object contains the state that will be saved and restored.
    //serializeBase sb = new serializeBase();

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
}

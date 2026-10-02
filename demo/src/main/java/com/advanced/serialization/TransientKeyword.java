package com.advanced.serialization;

public class transientKeyword extends serializeBase{

    // Docs: docs/concepts/serialization/transientKeyword.md (Part 1, line 10)

    public static void main(String[] args)
    {
        String filename = sampleDataPath("serialization","transientbasics.ser").toString();

        serializeBase sb = new serializeBase();

        sb.serialize(filename);
        sb.checkSerializationFileCreated(filename);
        sb.checkSerializationFileLocation(filename);
        sb.deserialize(filename);
    }
       


    
}

package com.advanced.serialization;

public class TransientKeyword extends SerializeBase{

    // Docs: docs/concepts/serialization/TransientKeyword.md (Part 1, line 10)

    public static void main(String[] args)
    {
        String filename = sampleDataPath("serialization","transientbasics.ser").toString();

        SerializeBase sb = new SerializeBase();

        sb.serialize(filename);
        sb.checkSerializationFileCreated(filename);
        sb.checkSerializationFileLocation(filename);
        sb.deserialize(filename);
    }
       


    
}

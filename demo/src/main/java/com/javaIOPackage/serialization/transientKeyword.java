package com.javaIOPackage.serialization;

public class transientKeyword extends serializeBase{

    /*
     *
     * transient modifier applicable only for variables butnot for methods and classes 
     * At the time of serialization if we dont want to save the value of a particular variable to meet security constraints
     * then we should decalare that variable as transient , while performing serialization JVM ignores the oroginal value of 
     * transient variable and save default value to the file, hence transient means not to serialize
     * =========== static vs transient
     * static variable is not part of object state and hence it won't participate in serialization, due to this declaring 
     * static variable as transient there is no use
     * =========== final vs transient
     * Final variables will be participated in serialization directly by the value(at compile time only) hence decalring a final 
     * variable as transient there is no impact
     */

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

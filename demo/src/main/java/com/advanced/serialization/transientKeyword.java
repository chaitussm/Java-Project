package com.advanced.serialization;

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
    * final and transient control different things. final prevents reassignment,
    * while transient prevents the field value from being written to the file.
    * Therefore, a final transient field is still excluded from serialization.
    * The .ser file is created, but it does not contain that transient value.
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
       
    //For final transeint secanrio refer the program reflectionVsDirectAccess.java program


    
}

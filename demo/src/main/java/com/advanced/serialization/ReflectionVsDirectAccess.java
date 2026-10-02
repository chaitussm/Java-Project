package com.advanced.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class reflectionVsDirectAccess extends fileBasicMethods {

    // Docs: docs/concepts/serialization/transientKeyword.md (Part 2, line 54)
    private static class SampleObject implements Serializable {

        private static final long serialVersionUID = 1L;

        // final prevents reassignment, while transient prevents serialization.
        final transient int j = 10;

        // This method may return 10 because the compiler can inline the constant.
        int readDirectly() {
            return j;
        }
    }

    public static void main(String[] args) throws Exception {
        String filename = sampleDataPath("serialization", "reflection-demo.ser").toString();

        // Create an object and write it to the serialized file.
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(new SampleObject());
        }

        // Read the object back from the serialized file.
        SampleObject restoredObject;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
            restoredObject = (SampleObject) input.readObject();
        }

        // Direct access may use the compile-time constant value 10.
        System.out.println("Without reflection: " + restoredObject.readDirectly());

        // Reflection reads the actual field value in the deserialized object.
        Field field = SampleObject.class.getDeclaredField("j");
        field.setAccessible(true);
        System.out.println("With reflection: " + field.get(restoredObject));

        System.out.println("Expected result: direct access may show 10, reflection shows 0.");
    }
}

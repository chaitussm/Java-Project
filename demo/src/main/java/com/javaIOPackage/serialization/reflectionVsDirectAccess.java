package com.javaIOPackage.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class reflectionVsDirectAccess extends fileBasicMethods {

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

    /*
     * COMPLETE EXECUTION SUMMARY: final transient int
     *
     * Field declaration:
     *
     *     final transient int j = 10;
     *
     * The two modifiers have different responsibilities:
     *
     *     final     -> normal Java code cannot assign a new value to j.
     *     transient -> j is not written into the serialized file.
     *
     * 1. COMPILATION
     *    Because j is a final primitive initialized with a constant, the Java
     *    compiler recognizes 10 as a compile-time constant. When normal code
     *    directly uses j, the compiler may place 10 directly in the bytecode.
     *    This compiler optimization does not put 10 into the serialized file.
     *
     * 2. ORIGINAL OBJECT
     *    A new SampleObject is created. Before serialization, its field slot
     *    contains j = 10. The final modifier prevents normal reassignment.
     *
     * 3. SERIALIZATION
     *    ObjectOutputStream writes the object's serializable state to:
     *
     *        demo/sample-data/serialization/reflection-demo.ser
     *
     *    Since j is transient, its value 10 is deliberately skipped. The file
     *    exists, but it does not contain a serialized value for j.
     *
     * 4. DESERIALIZATION
     *    ObjectInputStream creates a new SampleObject and reads the values that
     *    were saved. The constructor and ordinary field initialization are not
     *    used in the normal way for a Serializable object.
     *
     *    No value for j exists in the file because j was transient. Therefore,
     *    the actual int field slot in the restored object receives int's default
     *    value:
     *
     *        j = 0
     *
     *    The final modifier does not restore 10. It only controls reassignment.
     *
     * 5. DIRECT ACCESS WITHOUT REFLECTION
     *    readDirectly() uses ordinary Java access:
     *
     *        return j;
     *
     *    Because j is a compile-time constant, the compiler may effectively
     *    use return 10. This is why direct access can print 10, even though the
     *    actual deserialized field slot contains 0.
     *
     * 6. ACCESS WITH REFLECTION
     *    getDeclaredField("j") finds the field by its name at runtime.
     *    setAccessible(true) allows access to the field.
     *    field.get(restoredObject) reads the actual value in the restored
     *    object's field slot. It does not use the compiler's constant 10.
     *    Therefore, reflection prints 0.
     *
     * 7. FINAL DOES NOT MEAN SERIALIZED
     *    final does not override transient. These modifiers solve different
     *    problems: final controls reassignment, and transient controls storage.
     *    Reflection is only reading the value; it is not changing j.
     *
     * EXPECTED OUTPUT
     *
     *        Without reflection: 10
     *        With reflection: 0
     *
     * The results are not contradictory. Direct access may use the compiled
     * constant, while reflection reveals the actual value after deserialization.
     */
}

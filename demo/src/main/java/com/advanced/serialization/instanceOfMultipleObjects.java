package com.advanced.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class instanceOfMultipleObjects extends fileBasicMethods {

    // Both objects must implement Serializable before they can be written to a file.
    private static class Dog implements Serializable {
        private static final long serialVersionUID = 1L;

        void bark() {
            System.out.println("Dog-specific method: bark()");
        }
    }

    private static class Cat implements Serializable {
        private static final long serialVersionUID = 1L;

        void meow() {
            System.out.println("Cat-specific method: meow()");
        }
    }

    private static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        void study() {
            System.out.println("Student-specific method: study()");
        }
    }

    private static void handleDeserializedObject(Object object) {
        // Object is the parent type, so it can hold Dog, Cat, or Student objects.
        System.out.println("Object received: " + object.getClass().getSimpleName());

        // instanceof checks the real child type before casting the Object safely.
        if (object instanceof Dog) {
            // Object cannot call bark() directly; the cast exposes the Dog API.
            Dog dog = (Dog) object;
            dog.bark();
        } else if (object instanceof Cat) {
            // Object cannot call meow() directly; the cast exposes the Cat API.
            Cat cat = (Cat) object;
            cat.meow();
        } else if (object instanceof Student) {
            // Object cannot call study() directly; the cast exposes the Student API.
            Student student = (Student) object;
            student.study();
        }
    }

    private static void handleDeserializedObjects(Object... objects) {
        // The varargs parameter allows any number of objects to be supplied.
        // The for-each loop handles every object without repeating method calls.
        for (Object object : objects) {
            handleDeserializedObject(object);
        }
    }

    public static void main(String[] args)
    {
        String filename = sampleDataPath("serialization", "object-graph.ser").toString();

        // Create the objects in the order in which they will be serialized.
        Dog dog = new Dog();
        Cat cat = new Cat();
        Student student = new Student();

        // Write Dog first and Cat second into the same serialized file.
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            output.writeObject(dog);
            output.writeObject(cat);
            output.writeObject(student);
        } catch (IOException exception) {
            // IOException handles file or stream problems during serialization.
            System.out.println("Unable to serialize the object graph: "
                    + exception.getMessage());
            return;
        }

        // Read the objects back in exactly the same order in which they were written.
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(filename))) {
                // readObject() returns Object, so instanceof identifies each child type.
                Object firstObject = input.readObject();
                Object secondObject = input.readObject();
                Object thirdObject = input.readObject();

                // Approach 2: process all objects with one loop-based method call.
                handleDeserializedObjects(firstObject, secondObject, thirdObject);
        } catch (IOException | ClassNotFoundException exception) {
            // IOException handles file errors; ClassNotFoundException handles
            // a class that is unavailable while reading the serialized objects.
            System.out.println("Unable to deserialize the object graph: "
                    + exception.getMessage());
        }
    }
}

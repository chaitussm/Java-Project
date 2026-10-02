package com.advanced.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.javaIOPackage.baseMethodsInFileOperations.fileBasicMethods;

public class sequenceOfMultpleObjects extends fileBasicMethods {

	// Docs: docs/concepts/serialization/multipleObjectsSerialization.md (Part 1, line 10)
	private static class Dog implements Serializable {
		private static final long serialVersionUID = 1L;
	}

	private static class Cat implements Serializable {
		private static final long serialVersionUID = 1L;
	}

	public static void main(String[] args) {
		String filename = sampleDataPath("serialization", "multiple-objects.ser").toString();

		Dog dog = new Dog();
		Cat cat = new Cat();

		// Dog is written first and Cat is written second.
		try (ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(filename))) {
			output.writeObject(dog);
			output.writeObject(cat);
		} catch (IOException exception) {
			System.out.println("Serialization failed: " + exception.getMessage());
			return;
		}

		// Objects must be read in the same order in which they were written.
		try (ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(filename))) {
			Dog restoredDog = (Dog) input.readObject();
			Cat restoredCat = (Cat) input.readObject();

			System.out.println("First object: " + restoredDog.getClass().getSimpleName());
			System.out.println("Second object: " + restoredCat.getClass().getSimpleName());
		} catch (IOException | ClassNotFoundException exception) {
			System.out.println("Deserialization failed: " + exception.getMessage());
		}
	}
}

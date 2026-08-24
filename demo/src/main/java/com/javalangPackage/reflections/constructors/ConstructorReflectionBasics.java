package com.javalangPackage.reflections.constructors;

import java.lang.reflect.Constructor;

public class ConstructorReflectionBasics {

    // A class with two constructors for reflection to discover.
    @SuppressWarnings("unused")
    private static class Product {
        private final String name;
        private final int price;

        // Constructor with no arguments.
        private Product() {
            this("Notebook", 50);
        }

        // Constructor with two arguments.
        private Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " costs " + price;
        }
    }

    public static void main(String[] args) throws Exception {
        // Get the Class object representing Product.
        Class<Product> productClass = Product.class;

        // Get every constructor declared by Product, including private ones.
        for (Constructor<?> constructor : productClass.getDeclaredConstructors()) {
            System.out.println("Constructor: " + constructor);
        }

        // Find the private two-argument constructor by its parameter types.
        Constructor<Product> constructor = productClass.getDeclaredConstructor(
                String.class, int.class);

        // Allow reflection to access the private constructor.
        constructor.setAccessible(true);

        // Create a Product object by invoking the constructor dynamically.
        Product product = constructor.newInstance("Pen", 25);

        // Print the object created without using the new keyword for Product.
        System.out.println("Created object: " + product);
    }
}

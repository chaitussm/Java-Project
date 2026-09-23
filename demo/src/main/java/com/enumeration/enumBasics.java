package com.enumeration;

import java.lang.reflect.Method;

enum Protein {
    whey, casein, soy, yeast, plant;
}

public class enumBasics {

    enum food {
        fruits, vegetables, grains, nuts, legumes;
    }

    /**
     * Demonstrates enum constants for any enum type passed at runtime (same data as
     * {@code values()},
     * without calling {@code values()} via {@link java.lang.reflect.Method}).
     */
    public static <T extends Enum<T>> void demonstrateValuesMethod(Class<T> enumClass) {
        System.out.println("Demonstrating basic enum usage for " + enumClass.getSimpleName() + ":");
        T[] constants = enumClass.getEnumConstants();
        if (constants == null) {
            System.out.println("Error: " + enumClass.getSimpleName() + " is not an enum type");
            return;
        }
        for (T constant : constants) {
            System.out.println(constant);
        }
    }

    // Fixed: Dynamically invokes the static values() method via Reflection
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> void demonstrateValuesMethodWithReflections(Class<T> enumClass) {
        System.out
                .println("--- Demonstrating values() method via Reflection for " + enumClass.getSimpleName() + " ---");

        try {
            // 1. Find the static values() method declared inside the specific enum class
            Method valuesMethod = enumClass.getMethod("values");

            // 2. Invoke the method (passing null because it is a static method) and cast to
            // array
            T[] constants = (T[]) valuesMethod.invoke(null);

            // First iteration
            for (T p : constants) {
                System.out.println(p);
            }

            // Second iteration
            for (T f : constants) {
                System.out.println(f);
            }

        } catch (Exception e) {
            System.out.println("Failed to invoke values() method: " + e.getMessage());
        }
    }

    // Iterates through any provided Enum class type
    public static <T extends Enum<T>> void iterateAllInEnums(Class<T> type) {
        System.out.println("--- Iterating " + type.getSimpleName() + " ---");
        for (T p : type.getEnumConstants()) {
            System.out.println(p);
        }
    }

    // Fetches a single enum constant dynamically based on the passed Class type
    public static <T extends Enum<T>> void fetchSingleDataFromEnum(Class<T> enumClass, String name) {
        try {
            T p = Enum.valueOf(enumClass, name);
            System.out.println("Fetched: " + p);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + name + " is not a constant in " + enumClass.getSimpleName());
        }
    }

    public static void main(String[] args) {
        demonstrateValuesMethod(Protein.class);
        System.out.println();
        demonstrateValuesMethod(food.class);

        demonstrateValuesMethodWithReflections(Protein.class);
        System.out.println();
        demonstrateValuesMethodWithReflections(food.class);

        System.out.println("\n--- Via Class.getEnumConstants() ---");
        iterateAllInEnums(Protein.class);
        iterateAllInEnums(food.class);

        System.out.println("\n--- Total Counts ---");
        System.out.println("Total number of protein types: " + Protein.values().length);
        System.out.println("Total number of food types: " + food.values().length);

        System.out.println("\n--- Fetching Single Constants ---");
        fetchSingleDataFromEnum(Protein.class, "whey");
        fetchSingleDataFromEnum(Protein.class, "casein");
        fetchSingleDataFromEnum(Protein.class, "soy");
        fetchSingleDataFromEnum(Protein.class, "yeast");
        fetchSingleDataFromEnum(Protein.class, "plant");

        fetchSingleDataFromEnum(food.class, "fruits");
        fetchSingleDataFromEnum(food.class, "vegetables");
        fetchSingleDataFromEnum(food.class, "grains");
        fetchSingleDataFromEnum(food.class, "nuts");
        fetchSingleDataFromEnum(food.class, "legumes");
    }
}

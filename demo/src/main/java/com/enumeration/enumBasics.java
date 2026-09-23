package com.enumeration;

import java.lang.reflect.Method;

enum Protein {
    whey, casein, soy, yeast, plant;
}

public class enumBasics {

    enum food {
        fruits, vegetables, grains, nuts, legumes;
    }

    /** Prints each constant from a {@code values()} array (compiler-generated per enum type). */
    private static <T extends Enum<T>> void printEnumValues(T[] values) {
        for (T constant : values) {
            System.out.println(constant);
        }
    }

    /**
     * Demonstrates {@code values()} on {@link Protein} and nested {@link food}.
     * Each enum type has its own {@code values()} return type; one generic {@code T} cannot
     * iterate both {@code Protein.values()} and {@code food.values()} in the same loop.
     */
    public static void demonstrateValuesMethod() {
        System.out.println("Demonstrating basic enum usage:");
        System.out.println("--- Protein ---");
        printEnumValues(Protein.values());
        System.out.println("--- food ---");
        printEnumValues(food.values());
    }

    /** Invokes the compiler-generated static {@code values()} method via reflection. */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> void demonstrateValuesMethodV1(Class<T> enumClass) {
        System.out.println(
                "--- Demonstrating values() method via Reflection for " + enumClass.getSimpleName() + " ---");

        try {
            Method valuesMethod = enumClass.getMethod("values");
            T[] constants = (T[]) valuesMethod.invoke(null);
            for (T constant : constants) {
                System.out.println(constant);
            }
        } catch (ReflectiveOperationException e) {
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
        demonstrateValuesMethod();

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

        System.out.println("\n--- Demonstrating values() method for Protein ---");
        demonstrateValuesMethodV1(Protein.class);

        System.out.println("\n--- Demonstrating values() method for food ---");
        demonstrateValuesMethodV1(food.class);
    }
}

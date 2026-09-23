package com.enumeration;

enum Protein {
    whey, casein, soy, yeast, plant;
}

public class EnumBasics {

    enum food {
        fruits, vegetables, grains, nuts, legumes;
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
        // 1. Iterate through the enums
        iterateAllInEnums(Protein.class);
        iterateAllInEnums(food.class);

        System.out.println("\n--- Total Counts ---");
        System.out.println("Total number of protein types: " + Protein.values().length);
        System.out.println("Total number of food types: " + food.values().length);

        // 2. Fetch single data points dynamically
        System.out.println("\n--- Fetching Single Constants ---");
        fetchSingleDataFromEnum(Protein.class, "whey");
        fetchSingleDataFromEnum(Protein.class, "casein");
        fetchSingleDataFromEnum(Protein.class, "soy");
        fetchSingleDataFromEnum(Protein.class, "yeast");
        fetchSingleDataFromEnum(Protein.class, "plant");

        // This will now successfully fetch because we pass food.class
        fetchSingleDataFromEnum(food.class, "fruits");
        fetchSingleDataFromEnum(food.class, "vegetables");
        fetchSingleDataFromEnum(food.class, "grains");
        fetchSingleDataFromEnum(food.class, "nuts");
        fetchSingleDataFromEnum(food.class, "legumes");
    }
}

package com.enumeration;

public class enumAllMethods {

    enum rice {
        basmati, jasmine, arborio, sushi, brown, redmatta;
    }

    public static void demonstrateAllemthodsInEnum() {

        // Demonstrate all methods available in the enum
        rice[] allRiceTypes = rice.values();
        for (rice r : allRiceTypes) {
            System.out.println("Rice type: " + r);
        }

        // Demonstrate valueOf method
        rice specificRice = rice.valueOf("basmati");
        System.out.println("Specific rice: " + specificRice);

    }
}

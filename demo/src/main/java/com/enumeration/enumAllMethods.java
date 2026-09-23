package com.enumeration;

public class enumAllMethods {

    enum rice {
        basmati, jasmine, arborio, sushi, brown, redmatta;
    }

    public static void valueMethod() {

        System.out.println("--- Demonstrating values() method for rice enum ---");
        rice[] allRiceTypes = rice.values();
        for (rice r : allRiceTypes) {
            System.out.println("Rice type: " + r);
        }
    }

    public static void ordinalMethod() {
        System.out.println("--- Demonstrating ordinal() method for rice enum ---");
        rice[] allRiceTypes = rice.values();
        for (rice r : allRiceTypes) {
            System.out.println("Rice type: " + r + ", ordinal: " + r.ordinal());
        }
    }

    public static void demonstrateAllemthodsInEnum() {

        valueMethod();
        ordinalMethod();

    }

    public static void main(String[] args) {
        demonstrateAllemthodsInEnum();
    }
}

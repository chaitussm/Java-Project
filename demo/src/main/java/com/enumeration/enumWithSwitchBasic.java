package com.enumeration;

/**
 * Demonstrates enum {@code switch}: multi-case arrow (V1), enhanced arrow (V2),
 * and traditional colon (V3) with optional fall-through demo.
 */
public class enumWithSwitchBasic {

    enum pulses {
        lentils, chickpeas, beans, peas;
    }

    /** Java 21+ style: multiple constants in one case label, then {@code ->}. */
    public static void printEnumWithSwitchStatementV1(pulses pulse) {
        switch (pulse) {
            case lentils, chickpeas, beans, peas ->
                System.out.println("Pulse: " + pulse);
        }
    }

    /** Java 14+ enhanced switch — one constant per arrow; no fall-through. */
    public static void printEnumWithSwitchStatementV2(pulses pulse) {
        switch (pulse) {
            case lentils -> System.out.println("Lentils are great!");
            case chickpeas -> System.out.println("Chickpeas are versatile!");
            case beans -> System.out.println("Beans are nutritious!");
            case peas -> System.out.println("Peas are tasty!");
        }
    }

    /** Traditional switch — explicit {@code break;} required. */
    public static void printEnumWithSwitchStatementV3(pulses pulse) {
        switch (pulse) {
            case lentils:
                System.out.println("Lentils are great!");
                break;
            case chickpeas:
                System.out.println("Chickpeas are versatile!");
                break;
            case beans:
                System.out.println("Beans are nutritious!");
                break;
            case peas:
                System.out.println("Peas are tasty!");
                break;
        }
    }

    /** Shows fall-through when {@code break} is missing (traditional syntax only). */
    public static void printEnumWithSwitchFallThroughDemo(pulses pulse) {
        switch (pulse) {
            case lentils:
                System.out.println("V3 fall-through: lentils line (no break below)");
            case chickpeas:
                System.out.println("V3 fall-through: chickpeas line also runs");
                break;
            default:
                System.out.println("V3 fall-through: default");
        }
    }

    public static void main(String[] args) {
        printEnumWithSwitchStatementV1(pulses.lentils);
        printEnumWithSwitchStatementV1(pulses.chickpeas);
        printEnumWithSwitchStatementV1(pulses.beans);
        printEnumWithSwitchStatementV1(pulses.peas);

        System.out.println("\n=== V2 arrow -> ===");
        printEnumWithSwitchStatementV2(pulses.lentils);
        printEnumWithSwitchStatementV2(pulses.chickpeas);
        printEnumWithSwitchStatementV2(pulses.beans);
        printEnumWithSwitchStatementV2(pulses.peas);

        System.out.println("\n=== V3 colon : ===");
        printEnumWithSwitchStatementV3(pulses.lentils);
        printEnumWithSwitchStatementV3(pulses.chickpeas);
        printEnumWithSwitchStatementV3(pulses.beans);
        printEnumWithSwitchStatementV3(pulses.peas);

        System.out.println("\n=== Fall-through demo ===");
        printEnumWithSwitchFallThroughDemo(pulses.lentils);
    }
}

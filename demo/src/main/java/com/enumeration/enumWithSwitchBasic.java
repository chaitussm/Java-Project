package com.enumeration;

/**
 * Demonstrates enum {@code switch}: enhanced arrow ({@code ->}) vs traditional colon ({@code :}).
 */
public class enumWithSwitchBasic {

    enum Pulse {
        lentils, chickpeas, beans, peas
    }

    /** Java 14+ enhanced switch — no fall-through; arrow implies break. */
    public static void printEnumWithSwitchStatementV2(Pulse pulse) {
        switch (pulse) {
            case lentils -> System.out.println("V2: lentils are rich in protein.");
            case chickpeas -> System.out.println("V2: chickpeas are great in hummus.");
            case beans -> System.out.println("V2: beans are versatile legumes.");
            case peas -> System.out.println("V2: peas are small but nutritious.");
        }
    }

    /** Traditional switch — requires explicit {@code break;} to avoid fall-through. */
    public static void printEnumWithSwitchStatementV3(Pulse pulse) {
        switch (pulse) {
            case lentils:
                System.out.println("V3: lentils are rich in protein.");
                break;
            case chickpeas:
                System.out.println("V3: chickpeas are great in hummus.");
                break;
            case beans:
                System.out.println("V3: beans are versatile legumes.");
                break;
            case peas:
                System.out.println("V3: peas are small but nutritious.");
                break;
        }
    }

    /** Shows fall-through when {@code break} is missing (traditional syntax only). */
    public static void printEnumWithSwitchFallThroughDemo(Pulse pulse) {
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
        Pulse sample = Pulse.lentils;

        System.out.println("=== Enhanced switch (arrow ->) V2 ===");
        printEnumWithSwitchStatementV2(sample);
        printEnumWithSwitchStatementV2(Pulse.chickpeas);

        System.out.println("\n=== Traditional switch (colon :) V3 ===");
        printEnumWithSwitchStatementV3(sample);
        printEnumWithSwitchStatementV3(Pulse.beans);

        System.out.println("\n=== Fall-through demo (V3, missing break) ===");
        printEnumWithSwitchFallThroughDemo(Pulse.lentils);
    }
}

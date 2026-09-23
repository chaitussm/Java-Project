package com.enumeration;

enum pulses {
    rajma, urad, moong, chana;

    pulses() {
        System.out.println("A pulse has been created.");
    }
}

/**
 * Shows that enum instance constructors run once per constant when the enum class
 * is initialized—not only for the constant you reference in {@code main}.
 */
public class enumConstructor {

    public static void main(String[] args) {
        pulses pl = pulses.rajma;

        System.out.println("End of main method");
    }
}

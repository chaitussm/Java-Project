package com.enumeration;

enum pulses {
    rajma, urad, moong, chana;

    pulses() {
        System.out.println("A pulse has been created.");
    }
}

public class enumConstructor {

    public static void main(String[] args) {

        pulses pl = pulses.rajma;

        System.out.println("End of main method");

    }

}

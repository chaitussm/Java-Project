package com.enumeration;

enum Grain {

    WHEAT, BAJRA, RICE, BARLEY;

    public static void main(String[] args) {
        for (Grain grain : Grain.values()) {
            System.out.println("Grain: " + grain);
        }

        System.out.println("Total number of grains: " + Grain.values().length);
        System.out.println("Finished listing all grains.");
    }

}

public class mainMethodInsideEnum {

}

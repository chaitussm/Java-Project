package com.enumeration;

public class enumWithSwitchBasic {

    enum pulses {
        lentils, chickpeas, beans, peas;
    }

    // using -> lamda syntax
    public static void printEnumWithSwitchStatementV1(pulses pulse) {
        switch (pulse) {
            case lentils, chickpeas, beans, peas ->
                System.out.println("Pulse: " + pulse);
        }
    }

    public static void printEnumWithSwitchStatementV2(pulses pulse) {
        switch (pulse) {
            case lentils -> System.out.println("Lentils are great!");
            case chickpeas -> System.out.println("Chickpeas are versatile!");
            case beans -> System.out.println("Beans are nutritious!");
            case peas -> System.out.println("Peas are tasty!");
        }
    }

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

    public static void main(String[] args) {
        printEnumWithSwitchStatementV1(pulses.lentils);
        printEnumWithSwitchStatementV1(pulses.chickpeas);
        printEnumWithSwitchStatementV1(pulses.beans);
        printEnumWithSwitchStatementV1(pulses.peas);

        printEnumWithSwitchStatementV2(pulses.lentils);
        printEnumWithSwitchStatementV2(pulses.chickpeas);
        printEnumWithSwitchStatementV2(pulses.beans);
        printEnumWithSwitchStatementV2(pulses.peas);

        printEnumWithSwitchStatementV3(pulses.lentils);
        printEnumWithSwitchStatementV3(pulses.chickpeas);
        printEnumWithSwitchStatementV3(pulses.beans);
        printEnumWithSwitchStatementV3(pulses.peas);
    }

}

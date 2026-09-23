package com.enumeration;

public class enumWithSwitchAdvanced {

    enum vegetables {
        carrot, potato, tomato, cucumber, spinach;
    }

    enum spicies {
        cumin, turmeric, paprika, cinnamon, nutmeg;
    }

    // Fixed: Uses the base Enum type and checks the instances safely
    public static void printEnumWithSwitchStatementV1(Enum<?> enumConstant) {
        if (enumConstant instanceof vegetables veg) {
            switch (veg) {
                case carrot, potato, tomato, cucumber, spinach ->
                    System.out.println("Vegetable: " + veg);
            }
        } else if (enumConstant instanceof spicies spice) {
            switch (spice) {
                case cumin, turmeric, paprika, cinnamon, nutmeg ->
                    System.out.println("Spice: " + spice);
            }
        } else {
            System.out.println("Unknown enum constant: " + enumConstant);
        }
    }

    public static <T extends Enum<T>> void printEnumWithSwitchStatement(T enumConstant) {
        if (enumConstant == null) {
            System.out.println("Enum constant is null");
            return;
        }

        switch (enumConstant.name()) {
            case "carrot":
            case "potato":
            case "tomato":
            case "cucumber":
            case "spinach":
                System.out.println("Vegetable: " + enumConstant);
                break;

            case "cumin":
            case "turmeric":
            case "paprika":
            case "cinnamon":
            case "nutmeg":
                System.out.println("Spice: " + enumConstant);
                break;

            default:
                System.out.println("Unknown enum constant: " + enumConstant);
        }
    }

    public static void main(String[] args) {
        printEnumWithSwitchStatement(vegetables.carrot);
        printEnumWithSwitchStatement(spicies.cumin);
        printEnumWithSwitchStatementV1(vegetables.carrot);
        printEnumWithSwitchStatementV1(spicies.cumin);
    }

}

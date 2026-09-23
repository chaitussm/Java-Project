package com.enumeration.enumSpecialScenarios;

public class enumCaseOne {

    enum vegetables {
        carrot, potato, tomato, cucumber;
    }

    public static void main(String[] args) {

        System.out.println(vegetables.carrot.equals(vegetables.tomato));
        System.out.println(vegetables.carrot.hashCode() > vegetables.tomato.hashCode());
        System.out.println(vegetables.carrot.ordinal() < vegetables.tomato.ordinal());
        // System.out.println(vegetables.carrot > vegetables.tomato); not applicable
        // because for objects we can't write arithmetic comparisons

    }
}

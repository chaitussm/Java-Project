package com.enumeration.enumSpecialScenarios;

public class enumCaseTwo {

    enum color {
        RED, GREEN, BLUE
    }

    public static void main(String[] args) {
        for (color c : color.values()) {
            System.out.println(c);
        }
    }

}

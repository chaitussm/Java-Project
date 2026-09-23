package com.enumeration.enumSpecialScenarios;

public class enumCaseThree {

    enum bike {
        royalEnfield, triumph {
            public void type() {
                System.out.println("Triumph is a sports bike.");
            }
        },
        ducati, jawa;

        public void type() {

            System.out.println("This is a cruizer bike.");
        }

    }

    public static void main(String[] args) {
        for (bike b : bike.values()) {
            // System.out.println(b);
            b.type();
        }
    }

}

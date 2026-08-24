package com.advanced.reflections.fields;

import java.lang.reflect.Field;

public class FieldReflectionBasics {

    // A class containing fields with different access levels.
    @SuppressWarnings("unused")
    private static class Account {
        private String owner = "Ravi";
        public double balance = 1000.0;
        public static String bank = "Learning Bank";
    }

    public static void main(String[] args) throws Exception {
        // Create the object whose fields will be inspected.
        Account account = new Account();

        // Find the private owner field by name at runtime.
        Field ownerField = Account.class.getDeclaredField("owner");

        // Permit reflective access to the private field.
        ownerField.setAccessible(true);

        // Read the current value from this particular Account object.
        System.out.println("Owner before: " + ownerField.get(account));

        // Change the private field without calling a setter method.
        ownerField.set(account, "Meera");
        System.out.println("Owner after: " + ownerField.get(account));

        // Read a public instance field through reflection.
        Field balanceField = Account.class.getField("balance");
        System.out.println("Balance: " + balanceField.get(account));

        // Static fields belong to the class, so null is used as the object argument.
        Field bankField = Account.class.getDeclaredField("bank");
        System.out.println("Bank: " + bankField.get(null));
    }
}

package com.advanced.reflections.modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ModifierReflectionBasics {

    // Fields deliberately use different Java modifiers.
    @SuppressWarnings("unused")
    private static class Settings {
        public int normalValue = 1;
        private static final String APPLICATION = "Reflection Demo";
        protected transient int temporaryValue = 2;
    }

    public static void main(String[] args) {
        // Inspect every field declared in Settings.
        for (Field field : Settings.class.getDeclaredFields()) {
            // Convert the numeric modifier flags into readable words.
            String readableModifiers = Modifier.toString(field.getModifiers());

            // Check individual properties of the field.
            boolean isPrivate = Modifier.isPrivate(field.getModifiers());
            boolean isStatic = Modifier.isStatic(field.getModifiers());
            boolean isFinal = Modifier.isFinal(field.getModifiers());
            boolean isTransient = Modifier.isTransient(field.getModifiers());

            // Print the field metadata and the results of the modifier checks.
            System.out.println(field.getName() + " -> " + readableModifiers);
            System.out.println("  private=" + isPrivate
                    + ", static=" + isStatic
                    + ", final=" + isFinal
                    + ", transient=" + isTransient);
        }
    }
}

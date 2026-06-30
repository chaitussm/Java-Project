package com.objectoriented.mainmethods;

public class MainmethodDef {
    // Explanation of the `main` method:
    // 1. The `main` method is the entry point of a Java application — execution starts here.
    // 2. It must be declared `public static void`.
    // 3. `public`: accessible by the JVM from anywhere.
    // 4. `static`: callable without creating an instance; JVM calls it before any objects exist.
    // 5. `void`: indicates the method returns no value.
    // 6. The signature can accept `String[] args` for command-line arguments.
    // 7. `args` can be used to pass input or options to the program.
    
    public static void main(String[] args) {
        System.out.println("This is the main method definition");
    }

    // Variations (examples are commented out):
    // 1. Different modifier order is allowed: `static public void main(String[] args)`
    /*
    static public void main(String[] args) {
        System.out.println("This is the main method definition with 'static public' format");
    }

    // 2. Varargs form: `public static void main(String... args)`
    public static void main(String... args) {
        System.out.println("This is the main method definition with varargs format");
    }

    // 3. Additional modifiers (for demonstration only):
    final synchronized strictfp public static void main(String[] args) {
        System.out.println("This is the main method definition with 'final synchronized' format");
    }
    */

}

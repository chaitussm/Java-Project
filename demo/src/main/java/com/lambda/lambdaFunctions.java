package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class lambdaFunctions {

    public void demonstrateLambdaSyntax() {
        Runnable noParameter = () -> System.out.println("No parameter lambda");
        Consumer<String> oneParameter = message -> System.out.println("One parameter: " + message);
        BiFunction<Integer, Integer, Integer> multipleParameters = (first, second) -> first + second;
        Function<Integer, Integer> blockBody = number -> {
            int doubled = number * 2;
            return doubled;
        };

        noParameter.run();
        oneParameter.accept("Hello lambda");
        System.out.println("Multiple parameters: " + multipleParameters.apply(10, 20));
        System.out.println("Block body result: " + blockBody.apply(5));
    }

    public void demonstratePredicate() {
        Predicate<Integer> isEven = number -> number % 2 == 0;

        System.out.println("Predicate 8 is even: " + isEven.test(8));
        System.out.println("Predicate 7 is even: " + isEven.test(7));
    }

    public void demonstrateConsumer() {
        Consumer<String> printUpperCase = value -> System.out.println(value.toUpperCase());

        printUpperCase.accept("java lambda");
    }

    public void demonstrateFunction() {
        Function<String, Integer> textLength = text -> text.length();

        System.out.println("Length of Java: " + textLength.apply("Java"));
    }

    public void demonstrateSupplier() {
        Supplier<String> greeting = () -> "Hello from Supplier";

        System.out.println(greeting.get());
    }

    public void demonstrateUnaryOperator() {
        UnaryOperator<Integer> square = number -> number * number;

        System.out.println("Square of 6: " + square.apply(6));
    }

    public void demonstrateCollectionOperations() {
        List<String> names = new ArrayList<>(List.of("Chitra", "Asha", "Dinesh", "Bala"));

        names.removeIf(name -> name.startsWith("D"));
        names.replaceAll(name -> name.toUpperCase());
        names.sort((first, second) -> first.compareTo(second));

        System.out.println("Collection result: " + names);
    }

    public void demonstrateMethodReferences() {
        List<String> names = List.of("Asha", "Bala", "Chitra");

        names.forEach(System.out::println);
        names.stream().map(String::length).forEach(System.out::println);
    }

    public void demonstratePredicateComposition() {
        Predicate<Integer> positive = number -> number > 0;
        Predicate<Integer> even = number -> number % 2 == 0;
        Predicate<Integer> positiveAndEven = positive.and(even);

        System.out.println("6 is positive and even: " + positiveAndEven.test(6));
        System.out.println("-4 is positive and even: " + positiveAndEven.test(-4));
    }

    public static void main(String[] args) {
        lambdaFunctions demo = new lambdaFunctions();
        demo.demonstrateLambdaSyntax();
        demo.demonstratePredicate();
        demo.demonstrateConsumer();
        demo.demonstrateFunction();
        demo.demonstrateSupplier();
        demo.demonstrateUnaryOperator();
        demo.demonstrateCollectionOperations();
        demo.demonstrateMethodReferences();
        demo.demonstratePredicateComposition();
    }
}

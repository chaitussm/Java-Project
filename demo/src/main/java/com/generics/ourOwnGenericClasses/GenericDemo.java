package com.generics.ourOwnGenericClasses;

public class genericDemo {

    public static void main(String[] args) {
        genericBase<String> stringGeneric = new genericBase<>("Hello");
        stringGeneric.printGenericClass();

        genericBase<Integer> integerGeneric = new genericBase<>(123);
        integerGeneric.printGenericClass();

        genericBase<Double> doubleGeneric = new genericBase<>(45.67);
        doubleGeneric.printGenericClass();

        genericBase<Character> charGeneric = new genericBase<>('A');
        charGeneric.printGenericClass();

        genericBase<Boolean> booleanGeneric = new genericBase<>(true);
        booleanGeneric.printGenericClass();

        genericBase<Long> longGeneric = new genericBase<>(123456789L);
        longGeneric.printGenericClass();

        System.out.println("==================");

        // For nmultiple parameters

        genericBaseWithMulitpleParams<String, Integer> multipleParamsGeneric = new genericBaseWithMulitpleParams<>(
                "Hello", 123);
        multipleParamsGeneric.printGenericClass();

        genericBaseWithMulitpleParams<Double, Boolean> anotherMultipleParamsGeneric = new genericBaseWithMulitpleParams<>(
                45.67, true);
        anotherMultipleParamsGeneric.printGenericClass();

        genericBaseWithMulitpleParams<String, Double> yetAnotherMultipleParamsGeneric = new genericBaseWithMulitpleParams<>(
                "World", 89.01);
        yetAnotherMultipleParamsGeneric.printGenericClass();
    }

}

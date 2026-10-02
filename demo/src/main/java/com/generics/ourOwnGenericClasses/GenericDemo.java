package com.generics.ourOwnGenericClasses;

public class GenericDemo {

    public static void main(String[] args) {
        GenericBase<String> stringGeneric = new GenericBase<>("Hello");
        stringGeneric.printGenericClass();

        GenericBase<Integer> integerGeneric = new GenericBase<>(123);
        integerGeneric.printGenericClass();

        GenericBase<Double> doubleGeneric = new GenericBase<>(45.67);
        doubleGeneric.printGenericClass();

        GenericBase<Character> charGeneric = new GenericBase<>('A');
        charGeneric.printGenericClass();

        GenericBase<Boolean> booleanGeneric = new GenericBase<>(true);
        booleanGeneric.printGenericClass();

        GenericBase<Long> longGeneric = new GenericBase<>(123456789L);
        longGeneric.printGenericClass();

        System.out.println("==================");

        // For nmultiple parameters

        GenericBaseWithMulitpleParams<String, Integer> multipleParamsGeneric = new GenericBaseWithMulitpleParams<>(
                "Hello", 123);
        multipleParamsGeneric.printGenericClass();

        GenericBaseWithMulitpleParams<Double, Boolean> anotherMultipleParamsGeneric = new GenericBaseWithMulitpleParams<>(
                45.67, true);
        anotherMultipleParamsGeneric.printGenericClass();

        GenericBaseWithMulitpleParams<String, Double> yetAnotherMultipleParamsGeneric = new GenericBaseWithMulitpleParams<>(
                "World", 89.01);
        yetAnotherMultipleParamsGeneric.printGenericClass();
    }

}

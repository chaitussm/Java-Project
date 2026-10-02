package com.generics.ourOwnGenericClasses;

public class GenericBaseWithMulitpleParams<T, U> {
    private T firstParam;
    private U secondParam;

    public GenericBaseWithMulitpleParams(T firstParam, U secondParam) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    public void printGenericClass() {
        System.out.println("First parameter: " + firstParam.getClass().getName() + " - " + firstParam);
        System.out.println("Second parameter: " + secondParam.getClass().getName() + " - " + secondParam);
        System.out.println("==================");
        System.out.println(firstParam + " " + secondParam);
    }
}

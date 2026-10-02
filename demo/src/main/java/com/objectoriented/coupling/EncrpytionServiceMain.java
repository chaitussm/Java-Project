package com.objectoriented.coupling;

public class EncrpytionServiceMain {
    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor();
        encrpytionService es = new encrpytionService(dp);
        es.methodB();
    }
}

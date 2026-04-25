package com.objectoriented.coupling;

public class encrpytionServiceMain {
    public static void main(String[] args) {
        DataProcessor dp = new DataProcessor();
        encrpytionService es = new encrpytionService(dp);
        es.methodB();
    }
}

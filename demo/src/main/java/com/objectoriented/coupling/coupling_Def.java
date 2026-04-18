package com.objectoriented.coupling;

class DataProcessor {
    public void methodA() {
        System.out.println("Method A in Class A");
    }
}

class encrpytionService {
    private DataProcessor dataProcessor; // ClassB is dependent on DataProcessor

    public encrpytionService(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    public void methodB() {
        System.out.println("Method B in Class B");
        dataProcessor.methodA(); // Using DataProcessor's method, creating tight coupling
    }
}

public class coupling_Def {

    //the degree of dependence between two components ia called Coupling.High coupling is not a good programming practice because it makes the code less modular, harder to maintain, and more difficult to understand. When components are tightly coupled, changes in one component can have a ripple effect on other components, leading to bugs and unintended consequences. It also makes it harder to reuse components in different contexts, as they may be dependent on specific implementations of other components.
    //Low coupling, on the other hand, promotes modularity, maintainability, and reusability. It allows developers to understand and modify specific components without affecting the entire system, leading to

    // more efficient and effective software development.

    public static void main(String[] args) {

        DataProcessor dataProcessor = new DataProcessor();
        encrpytionService encryptionService = new encrpytionService(dataProcessor);
        encryptionService.methodB();    
    
    }
    
}

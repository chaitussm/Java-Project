package com.objectoriented.cohesion;


// Class responsible only for mathematical operations
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}



// Class responsible only for communication tasks
class NotificationService {
    public void sendEmail(String message) {
        System.out.println("Email sent with content: " + message);
    }
}

public class cohesionDef {

    //If any component is having welldefined functionality then that component is having high cohesion and if any component is having more than one functionality then that component is having low cohesion.
    //High cohesion is desirable in software design because it promotes modularity, maintainability, and reusability. It allows developers to understand and modify specific components without affecting the entire system, leading to more efficient and effective software development.
   
    // High Cohesion: Each class has one specific purpose
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        NotificationService notifier = new NotificationService();
        
        int result = calc.add(5, 10);
        notifier.sendEmail("The result is " + result);
    }


    
    
}

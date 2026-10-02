package com.objectoriented.constructors;

public class super_thisVariations extends prototypeConstructor {

    //NOTE
   
    public void m1(){
        System.out.println("m1 method is called");
    }

    public void m2(){
        System.out.println("m2 method is called");
        this.m1();
        super.p1();//Here we using super keyword to call the method of the parent class because if we are using this keyword to call the method of the parent class then we will get compile time error because this keyword is used to call the method of the current class and super keyword is used to call the method of the parent class
    }   

    public static void main(String[] args) {
        
        super_thisVariations obj = new super_thisVariations();
        obj.m2();
        // We cannot use the instance of the class inside static methods 
        // because if we are using the instance of the class inside static methods then we will 
        // we will get compile time error because static methods are not associated with any instance of the class and they are associated with the class itself
    


    }
    
}

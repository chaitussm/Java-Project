package com.fundamentals.Interface;

interface A {
    void methodA();
}

interface B {
    void methodA();
}

public class InterfaceCaseOne implements A, B  {

    //If 2 interafces are having same method name then we have to 
    // override the method in the class which is implementing both the interfaces and we have to provide the implementation for both the methods in the class because if we do not provide the implementation for both the methods then it will give a compile time error because it will not know which method to call when we call the method from the object of the class.
   public void methodA() {
        System.out.println("Method A implementation");
    }

    public static void main(String[] args) {
        InterfaceCaseOne obj = new InterfaceCaseOne();
        obj.methodA();
    }
}

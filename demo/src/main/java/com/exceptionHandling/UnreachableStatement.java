package com.exceptionHandling;

public class unreachableStatement {
    
    /*In the below first example compiler knows that we are trying to throw the exception and the program 
    will be terminated after the throw keyword making print statement as unreachable
    In second example we can throw only throwable types if we use any other we get below error
    error : exception unreachableStatement is never thrown in body of corresponding try statement
    */



    public static void main(String[] args) {
    
        throw new ArithmeticException("This is an example of an unreachable statement.");

        //1.System.out.println("This statement is unreachable and will never be executed.");

        //2.throw new unreachableStatement();

    }

}

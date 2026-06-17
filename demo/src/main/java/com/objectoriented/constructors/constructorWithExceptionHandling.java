package com.objectoriented.constructors;

//NOTE 
//1. In the belwo sceanrio the caller constructoir should throws same exception or its parent exception.
//2. Else we may get the error as below:
/*
Error: Unreported exception Exception in constructor; must be caught or declared to be thrown
 */
//3. Generally we can handle this in 2 ways for general methods 
// one is by using try catch block and the other one is throwing the same exception or its parent exception 
// But for the constructor scenario try catch is not allowed beacuse the first line of the code will be this() or super() only.

public class constructorWithExceptionHandling extends constructorWithCheckedException{

    constructorWithExceptionHandling() throws Exception {
        super();
    }

}

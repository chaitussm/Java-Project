package com.objectoriented.constructors;

// NOTE
// 1. In the below scenario the caller constructor should declare the same exception or a parent exception using `throws`.
// 2. Otherwise you may see an error such as:
/*
Error: Unreported exception Exception in constructor; must be caught or declared to be thrown
*/
// 3. For regular methods, exceptions can be handled with `try/catch` or declared with `throws`.
// 4. For constructors, `try/catch` cannot surround `this()` or `super()` because those calls must be the first statement.

public class constructorWithExceptionHandling extends constructorWithCheckedException{

    constructorWithExceptionHandling() throws Exception {
        super();
    }

}

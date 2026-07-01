package com.exceptionHandling;

public class defineOurOwenException extends RuntimeException {
   
    /*In this case we are already extending the runtime exception which makes the class throwable*/

    public static void main(String[] args) {
      throw new defineOurOwenException();
    }
    
}

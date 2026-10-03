# Introduction

Very common way of debugging is usage of sop (System.out.println) statements. But the problem with sop's is after fixing the bug/defect compulsory we have to delete sop statements otherwise these sop's will be executed at runtime for every client request , which creates performace problem and disturbs server logs, 
      To overcome this problem sun people introduced assertions concept in 1.4 version

The main advantage of assertions when compared with sop's is after fixing the bug/defect we are not required to remove assert statements because they won't be executed by default at runtime based on our requirement we can enable and disable assertions and by default assertions are disabled.

The main objective of assertions is to perform debugging by validating assumptions made in the code during development.

Usually we can perform debugging in developement and test environments but not in production environment , hence assertions concept applicable mainly in development and test environments but not for production environment.




# assert as keyword and identifier 

assert keyword introduced in 1.4 version hence from 1.4 version onwards we can't use assert as identifier otherwise we will gety compile time error 

class Test
{
   public static void main(String[] args)
   {
     int assert = 10;
     System.out.println(assert);
   }
}

output : 'assert' is a keyword use -source 1.3 or lower to use assert as identifier

we have to run by uisng like this 

javac -source 1.2 Test.java 

javac -source 1.3 Test.java

NOTE : 

1. If we are using assert as identifier and if we are trying to compile according to old version(1.3 or lower) then the code compiles fine but with warnings 
2. We can compile a java program according to a particular function by using -source option

# Types of assert statements 

There are 2 types of assert statements 

a. Simple version 
b. Augumented version 

Simple version: 

>assert(b);

b should be boolean type 
1. if b is true then our assumption satisfy and hence rest of program will be executed normally
2. if b is false then our assumption fails i.e somewhere something goes wrong and hence the program will be terminated abnormally by raising AssertionError
3. Once we got Assertion Error we will analyze the code and we can fix the problem 


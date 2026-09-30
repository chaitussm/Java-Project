# javac 

we can use javac command to compile a single or group of java source files 

>javac [options] Test.java
>javac [options] A.java B.java C.java
>javac [options] *.java

options may be -version, -d, -source, -verbose , -cp|-classpath

# java 

We can use java command to run a single class file 

>java [options] Test A B C 

A, B, C are command line arguments 

options may include -version, -d, -source, -verbose , -cp|-classpath, -ea|-esa|-dsa|-da

NOTE : 

We can compile any number of source files at a time but we can run only one class file at a time 

# classpath 

classpath describes the location where required .class files are available java compiler and jvm will use classpath to locate required .class file

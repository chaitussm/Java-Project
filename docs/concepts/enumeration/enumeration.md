# Introduction 

If we want to represent a group of named constants then we should go for enum 

Example : 

enum Month
{
    Jan,Feb...Dec;
}

enum temples
{
    Kaashi,tirupathi...Kanchi;
}

The main objective of enum is to define our own datatypes(enumerated datatypes)

Enum concept introduced in 1.5 version when compared with old languages enum java enum is more powerful 

1. Every enum is internally implemented by using class concept 
2. Every enum constant is always public static final 
3. every enum constant represents an object of the type enum 

enum Fruits 
{
    mangoes, pomegrante;
}

internally the enum structure is 



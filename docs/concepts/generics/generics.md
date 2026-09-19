# Introduction

The main objectives of generics are to provide type safety and resolution of type casting problems

# Case 1: Type Safety

Arrays are type-safe i.e we can give the gurantee for the type of elements present inside array

for example: if our programming requirement is to hold only String type of objects we can choose String array by mistake if we are trying to add
any other type of objects we will get compile-time error saying incompatible types 

>String[] s = new String[1000];
s[0] = "Shiva";
s[1] = "Shakthi";
s[2] = new Integer(10);//we will get  incompatible types  error 

But Collections are not type-safe i.e we can't give tthat gurantee for the type of elements present inside collection 

for example: if our programming requirement is to hold only String type of objects and if we choose arraylist , by mistake if we trying to add any other type of object we won't get any compile-time error but the program may fail at run-time 


>ArrayList al = new ArrayList();
al.add("durga");
al.add("Lakshmi");
al.add(new Integer(10));

to retrieve the above elements 

String name1 = (String)l.get(0);
String name2 = (String)l.get(1);
String name3 = (String)l.get(2);//for this line we will get ClassCastException

hence we can't give the guarentee for the type of elements present inside collection due to this collections are not safe to use with respect to 
type i.e collections are not type-safe.

# Case 2: Type Casting and impact of this on Collections 

In the case of arrays at the time of retrievel its not erquired to perfomr type-casting beacause there is gurantee for the type of elements present inside array.

>String[] s = new String[1000];
s[0] = "Shiva";// type casting is not required


In the case of Collections at the time of retrievel compulsory we should perform typecasting beacaue there is not gurantee for the type of elements present insid collection

>ArrayList al = new ArrayList();
al.add("durga");
al.add("Lakshmi");
al.add(new Integer(10));

to retrieve the above elements 

type casting is mandatory 
String name1 = (String)l.get(0);

For example to hold only String type Objects we can create generic version of arraylist object as follows 

ArrayList<String> l = new ArrayList<String>();

For this arraylist we can add only String type objects by mistake if we are trying to add any other type then we will get compile time error 

l.add("durga");//valid
l.add("shiva");//valid 
l.add(new Integer(10));//compiletimeerror

At the retrieval we are not required to perform type casting 

String name = l.get(0);//type casting is not required 

# Conclusions 

1. polymorphism concept is applicable only for base type but not for parameter type.
   (usage of parent reference to hold child object is the concept of polymorphism)

   ArrayList<String> l = new ArrayList<String>(); //ArrayList--> Basetype , String---> parameter type
   List<String> l = new ArrayLIst<String>();
   Collection<String> l = new ArrayList<String>();
   ArrayList<Object> l = new ArrayLIst<String>();
   for the above code we will get compile time error saying 
   "incompatible types"
   found: ArrayList<String>
   required: ArrayList<Object>
2. For the type parameter we can provide any class or interface name but not primitives if we are trying to provide primitive then we will get 
   compile time error 

   ArrayList<int> l = new ArrayList<int>();
   for the above code we will get compile time error saying
   "unexpected Type"
   found: int 
   required: reference
=====================================================

Until 1.4 version a non-generic arraylist class is declared as follows 

class Arraylist
{
    add(Object o);
    Object ob = get(int index); 
}

The argument to add() is object and hence we can add any type of object to the arraylist due to this we are missing type-safety 
The return type of get() is object hence at the time of retrieval we haver to perform type-casting 







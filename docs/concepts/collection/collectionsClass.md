# Collections Class 

collections class defines several utility methods for collection objects like sorting , searching and reversing etc

# Sorting elements of List 

1. collections class defines the following 2 sort methods 
> public static void sort(List l)

  1. To Sort based on default natural sorting order
  2. In this case list should compulsory contains homogeneous and comparable objects otherwise we will get runtime excception saying 
     ClassCastException 
  3. List shouldn't contains null otherwise we will get NullPointerException
2.
>public static void sort(List l, Comparator c)
  1. To sort based on customized sorting order 

3.Collections class defines the following binary search methods 
  
>public static int binarySearch(List l, Object target)
 
 If the list is sorted according to default natural sorting order then we have to use this method 

>public static int binarySearch(List l, Object target,Comparator c) 

 We have to use this method if the list is sorted according to customized sorting order

# Conclusions 

1. The above search methods internally will use binarySearch algorithm 
2. Successful search returns index 
3. Unsuccessful search returns insertion point 
4. Insertion point is the location where we can place target element in the sorted list 
5. Before calling binarySearch() method compulsory list should be sorted otherwise we will get unpredictabe results 
6. If the list is sorted according to Compartor then at the time of search operation also we have to pass same comparator object otherwise 
   we will get unpredictable results. 

NOTE: 
For the list of 'n' elements in the case of binary search method 
1. successful search result range : 0 to n-1
2. unsuccessful search result range : -(n+1) to -1
3. total results range : -(n+1) to n-1

Collections class defines the following reverse() to reverse elements of list  

>public static void reverse(List l)

# reverse vs reverseOrder() 

we can use reverse() to reverse the order of elements of list 
whereas we can use reverseOrder() to get reversed Comparator
>Comparator c1 = Collections.reverseOrder(Comparator c)




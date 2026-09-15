# Arrays Class 

Arrays class is an utility class to define several utility methods for array objects 

Arrays class defines the following sort methods to sort elements of primitive and Object type arrays

>public static void sort(primitve[] p) 
 To sort according to Natural sorting order 
>public static void sort(Object[] p)
 To sort according to Natural sorting order 
>public static void sort(Object[] p , Comparator c)
 TO sort according to customized sorting order

 NOTE: 
 We can sort primitive arrays only based on default natural sorting order whereas we can sort Object arrays either based on default natural sorting 
 order or based on customized sorting order.

 # Searching the elements of Array 

Arrays class defines the following binary search methods

>public static int binarySearch(primitive[] p , primitive target)
>public static int binarySearch(Object[] p , Object target)
>public static int binarySearch(Object[] p , Object target , Comparator c

NOTE: 
All rules of arrays class binary search() methods are exactly same as Collections class binarySearch() methods 

# Conversion of array to list 

>public static List asList(Object[] a)

1. Strictly speaking this method won't create an independent list Object for the existing array we are getting list view 
2. By using array reference if we perform any change automatically that change will be reflected to the list, similarly ifd we perform any change
   that change will be reflected automatically to the array
3. By using list reference we can't perform any operation which varies the size.Otherwise we will get runtime excepotion saying 
   UnsupportedOperationException
   l.add("M") or l.remove(l); //UnsupportedOperationException
   l.set(1,N) // valid
4. By using list reference we are not allowed to replace with heterogeneous objects otherwise we will get runtime exception saying 
   ArrayStoreException
   l.set(l, new Integer(10))//ArrayStoreException






# concurrentCollections 

In Java, concurrent collections are a set of highly optimized, thread-safe data structures found in the java.util.concurrent package [java.util.concurrent package]. They allow multiple threads to read and write data simultaneously without corrupting the data or throwing a ConcurrentModificationException.They were introduced in Java 5 to replace older, slower synchronization methods by using clever performance tricks like lock striping and Compare-And-Swap (CAS) algorithms.

# Importance of concurrent Collections 

1. Most of the already existing collections objects are thread unsafe may be data inconsistency problems
2. Very few already existing collections are thread safe but performance is slow, because at a time our collection object can be accessed by only one  thread even for read operation also total collection object will be locked due to locking mechanism at a time only one thread is allowed to operate on one Object 
3. While one thread is iterating collection object the other thread is not allowed to perform any modification by mistake if we trying to perform any modification we will get an exception ConcurrentModificationException
   

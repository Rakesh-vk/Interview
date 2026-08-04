package interview;

public class test {
}

/*Question 1: Relationship between `equals` and `hashCode` in Java**
Explain the relationship between the `equals` and `hashCode` methods in Java.
 Why is it important to override both methods when creating custom objects?
  Provide an example where failing to do so causes unexpected behavior in a `HashSet`.

        2. **Question 2: Java Heap Memory and Generations**
Describe how objects are allocated and managed in Java heap memory.
 Explain the concept of different generations (Young Generation,
  Old Generation, and Permanent Generation/Metaspace) and how garbage
   collection works across these generations. Why is this generational
    model important for performance?
        3. **Question 3: Dependency Injection in Java**
Explain the concept of Dependency Injection (DI) in Java.
How does it work, and what are the benefits of using DI in
software development? Provide a simple example of DI using a
Java framework like Spring to demonstrate how it improves code
 maintainability and testability.


        // 1.  the equals() method is used to determine logically equivalent between two objects
            hashcode() method is used to get the integer hash value used in hash-based collections to find the bucket like hashmap
            the relation is if equals is not implement correctly even if the key and value is present we may not get the result.
            if the hashcode is not implemented correctly then bucket number will calculate wrongly and will result in hotspots or loss of data

            2. java memory
            young generation : new objects are allocated in Eden space it is also called as young generation
            most memory object die here.
            ex temp object

             old generation: this the space where the object have survived the minor GC
             it contains s1 and s2
             Eden -> survivor1 -> survivor2

             parmanent / metaspace
             used to store permanent generation(PermGen)
             stored: class metadata, method info
              in java8+ it is replaced by metaspace

              3. Dependency Injection : is a design pattern where and object's dependency are provided from the outside rather than creating it by self or by creating the object itself
 */

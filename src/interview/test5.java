/*public class test5 {
}
        n Java, keys in a Map should ideally be immutable. This is because the Map relies on the hash code of the key to store and retrieve values efficiently. If a key is mutable and its state changes after it has been added to the Map, its hash code may change, making it impossible to locate the key in the Map. This can lead to unexpected behavior, such as not being able to retrieve a value using a key that is still logically present in the Map.
Consider the following Java code snippet:
        ```java
import java.util.HashMap;
import java.util.Map;
class MutableKey {
    private String keyPart;
    public MutableKey(String keyPart) {
        this.keyPart = keyPart;
    }
    public void setKeyPart(String keyPart) {
        this.keyPart = keyPart;
    }
    @Override
    public int hashCode() {
        return keyPart.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MutableKey that = (MutableKey) obj;
        return keyPart.equals(that.keyPart);
    }
}
public class MapExample {
    public static void main(String[] args) {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("initial");
        map.put(key, "value");
        System.out.println("Before mutation: " + map.get(key)); // What will this print?
        key.setKeyPart("changed");
        System.out.println("After mutation: " + map.get(key)); // What will this print?
    }
}
```
Predict the output of the above code snippet and explain why the output is as it is


before mutation : value
after mutation : null
hashmap uses the key's hashcode to determine the bucket initially the key's hashcode was based on initial so the entry was stored in bucket after changing the key part changed the hashcode changes so map.get() is resutning null when called once again



xplain Java's memory model by answering the following questions:

        1. What is the difference between the heap and the stack in Java memory management? Include details about what types of data are stored in each.
2. How does Java's garbage collector work, and which part of memory does it primarily interact with?
        3. Provide an example Java program that demonstrates the allocation of variables on the stack and objects on the heap. Walk through how memory is managed for this program.

Example code snippet:
        ```java
public class MemoryExample {
    public static void main(String[] args) {
        int number = 10; // Stored on the stack
        String text = "Hello"; // Stored on the heap (interned string pool)

        Person person = new Person("John", 25); // Object stored on the heap
        person.displayInfo();
    }
}

class Person {
    private String name; // Stored on the heap
    private int age;     // Stored on the heap

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

Using the provided code, explain:
        - Where `number`, `text`, and the `Person` object are stored in memory.
- How the garbage collector would handle the `Person` object if it becomes unreachable.


        difference between heap and stack is stack is used to store the local variable , it is method frames, primitive and locval variable where as heap stored the objects and arrays and insrtance variable stores the getObjects

        GC in java GC is done automatically by the JVM it uses auto memory management.
        GC automatically removes the objects that are no longer reachable
        it primarly works on heap memory
        it dose not clean stack memory*/
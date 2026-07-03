/*Implement a thread-safe Singleton class in Java. Your implementation should ensure that only one instance of the class is created, even in a multithreaded environment. Use lazy initialization to create the instance only when it is needed. Additionally, apply the double-checked locking pattern to optimize performance.

Provide a complete implementation of the Singleton class, and explain the trade-offs between lazy initialization and eager initialization in the context of thread safety and resource management.

Here is a starting point for your implementation:

        ```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
```

Complete the `getInstance` method to ensure thread safety using the double-checked locking pattern. After implementing the class, discuss the following:
        1. How does the double-checked locking pattern work in this implementation?
        2. What are the advantages and disadvantages of lazy initialization compared to eager initialization?


 */
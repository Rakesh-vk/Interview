package Langauge.Java8;
// A Functional Interface in Java is an interface that contains exactly one abstract method.
/*
It can have:
multiple default methods
multiple static methods
methods from Object class (toString, equals, etc.)
But only one abstract method is allowed.

Java introduced Functional Interfaces mainly for:
Lambda expressions
Method references
Functional programming style APIs (Streams, CompletableFuture, etc.)

Examples:
Runnable
Callable
Comparator
Consumer
Predicate
Function
Supplier
Java provides @FunctionalInterface annotation to enforce this rule at compile time.

before java 8
We used anonymous inner classes.
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};
Problem:
 verbose
 creates extra class
 less readable

 java 8 lambda implementation
 Runnable r = () -> System.out.println("Running");

Java compiler does NOT create a normal anonymous inner class directly.

Instead:
compiler uses invokedynamic
JVM creates implementation dynamically at runtime
handled through LambdaMetafactory

This reduces:
class file generation
memory overhead
startup cost

Difference between Functional Interface and Normal Interface?
Functional Interface	            Normal Interface
Only one abstract method	        Multiple abstract methods allowed
Used for lambda expressions	        General contract definition
Supports functional programming	    Traditional OOP

functional interface can have default and static methods and all the methods from object class

functional interface can extend other interface only if it contains only one abstract method

 */

public class FunctionalInterface {
    public static void main(String[] args) {
        int x=10;
        // lambda expression before java 8
        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println("hello "+x);
            }
        };
        // lambda expression after java 8
        Runnable r=()-> System.out.println(x);
        r.run();
    }
}

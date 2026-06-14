package Langauge.Java8;

import java.util.concurrent.atomic.AtomicInteger;

// A Lambda Expression is a concise way to provide the implementation of a Functional Interface.
// (parameters) -> expression or (parameters) -> { expression1 , expression2}
/* It represents:
anonymous function
no name
no return type declaration
no access modifier

Anonymous Class vs Lambda Internals
Anonymous class:
creates separate .class file
Lambda:
uses runtime dynamic linkage
fewer class files
lighter memory footprint

Why local variables must be effectively final?
Because:
lambda may execute later
local variable may already be destroyed from stack
captured copy avoids unsafe mutation



Advantages:
 less boilerplate
 cleaner code
Problems:
 excessive nesting hurts readability
 debugging harder
 variable capture restrictions
*/
public class LambdaExpression {
    public static void main(String[] args) {
        Runnable r= new Runnable() {
            @Override
            public void run() {
                System.out.println("this is before java 8 ");
            }
        };

        Runnable r1=()-> System.out.println("this is after java 8 implementation");
        r.run();
        r1.run();

        AtomicInteger a= new AtomicInteger();
        Runnable r2= a::getAndIncrement;
    }
}

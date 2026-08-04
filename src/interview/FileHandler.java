package interview;/*xplain the concept of checked exceptions in Java. Discuss the advantages and disadvantages of using checked exceptions in a Java application. Provide examples to illustrate your points.

        Advantages:
        1. Checked exceptions enforce error handling at compile time, ensuring that the programmer handles potential exceptions.
        2. They make the code more robust and reliable by forcing developers to consider error scenarios.

        Disadvantages:
        1. Checked exceptions can lead to verbose code, as developers must handle exceptions even when they are unlikely to occur.
        2. They can lead to poor error handling practices, such as catching exceptions and ignoring them or converting them to unchecked exceptions.

        Example:
        Consider a method `readFile` that reads data from a file. Demonstrate how checked exceptions are used in this context, and discuss the implications of using them.

        ```java*/

// problem not closing the bufferedReader
// solution use the Try with resources to auto close the resource once done and catch the exception while reading the data from bufferedReader

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args) {
        try {
            readFile("example.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static void readFile(String fileName) throws IOException {
       try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){;
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
// Analyze the above code and discuss how the use of checked exceptions affects the design and error handling strategy.
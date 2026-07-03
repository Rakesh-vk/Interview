package interview;/*You are tasked with designing a REST API for a payment processing system.

        1. Explain the concept of idempotency in the context of REST APIs.
         Which HTTP methods are required to be idempotent according to the HTTP specification,
          and why is this important?

        2. In the case of a "Create Payment" endpoint, which typically uses the POST method,
         how would you ensure idempotency to handle scenarios where duplicate payment requests
          are received (e.g., due to client retries or network issues)? Provide a high-level
          design or mechanism to address this.

        3. Write a Java method `processPayment` that simulates handling a payment request.
         Assume the payment request includes a unique `idempotencyKey` to ensure idempotency.
          If the key has already been processed, the method should return a message indicating
           the payment was already processed. Otherwise, it should process the payment and
           store the key. Use a `HashSet` to simulate storage for processed keys.

        ```java*/
import java.util.HashSet;
// 1. idempotency means same request sent multiple times has the same effect as making it once
// 2. since POSt is not inherited idempotency, we can add an idempotence-key
// Header:
// Idempotency-key : <key>
// store it in DB anc check for each request that request is already present or not if not then process and save it else return the previous status
public class PaymentProcessor {
    private HashSet<String> processedKeys = new HashSet<>();

    public String processPayment(String idempotencyKey) {
        // Implement the logic to check and process the payment
        if(processedKeys.contains(idempotencyKey)){
            return "Payment already in processing";
        }
        processedKeys.add(idempotencyKey);
        return " payment processed successfully for key";
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        System.out.println(processor.processPayment("key123")); // First attempt
        System.out.println(processor.processPayment("key123")); // Duplicate attempt
    }
}


// Complete the `processPayment` method to handle idempotency as described
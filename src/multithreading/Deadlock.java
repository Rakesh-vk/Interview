package multithreading;

import java.util.concurrent.locks.Lock;

public class Deadlock {
    public static void main(String[] args) {
        final String resource1 = "Resource 1";
        final String resource2 = "Resource 2";


        // Thread 1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked Resource 1");

                 try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 1: Waiting for Resource 2...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked Resource 2");
                }
            }
        });

        // Thread 2 tries to lock resource2 then resource1
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked Resource 2");

                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for Resource 1...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked Resource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

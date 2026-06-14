package Langauge.multithreading;

public class Deadlock {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (resourceA) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " locked Resource-A"
                );

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting for Resource-B"
                );

                synchronized (resourceB) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " locked Resource-B"
                    );
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (resourceB) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " locked Resource-B"
                );

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(
                        Thread.currentThread().getName()
                                + " waiting for Resource-A"
                );

                synchronized (resourceA) {

                    System.out.println(
                            Thread.currentThread().getName()
                                    + " locked Resource-A"
                    );
                }
            }
        });

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}

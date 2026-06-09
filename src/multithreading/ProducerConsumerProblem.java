package multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

    private Queue<Integer> queue = new LinkedList<>();
    private int limit;
    private int[] arr;
    private int index = 0;

    ProducerConsumerProblem(int limit, int[] arr) {
        this.limit = limit;
        this.arr = arr;
    }

    // Producer
    public synchronized void producer() {

        while (index < arr.length) {

            // wait if buffer is full
            while (queue.size() == limit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int item = arr[index];

            queue.add(item);

            System.out.println("Produced : " + item);

            index++;

            // notify consumer
            notifyAll();
        }
    }

    // Consumer
    public synchronized void consumer() {

        int consumedCount = 0;

        while (consumedCount < arr.length) {

            // wait if queue is empty
            while (queue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int item = queue.remove();

            System.out.println("Consumed : " + item);

            consumedCount++;

            // notify producer
            notifyAll();
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        ProducerConsumerProblem p1 =
                new ProducerConsumerProblem(3, arr);

        Thread producerThread = new Thread(() -> {
            p1.producer();
        });

        Thread consumerThread = new Thread(() -> {
            p1.consumer();
        });

        producerThread.start();
        consumerThread.start();
    }
}
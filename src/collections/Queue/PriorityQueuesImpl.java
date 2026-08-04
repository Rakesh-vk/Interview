package collections.Queue;

import java.util.PriorityQueue;

public class PriorityQueuesImpl {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(50);
        System.out.println(pq.peek());;
    }
}

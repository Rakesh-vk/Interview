package collections.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapUsingPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(40);
        pq.add(1);
        pq.add(120);
        // priorityQueue is backed by array, so when we call toString() it will iterate the array
        // resulting in the unsorted elements
        System.out.println(pq.toString());
        // when we use poll() it will remove and return the highest priority element.
        while(pq.size()>0){
            System.out.println(pq.poll());
        }


    }
}

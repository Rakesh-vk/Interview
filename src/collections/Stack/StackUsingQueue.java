package collections.Stack;

import java.util.*;

public class StackUsingQueue {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3};
        printQueue(arr);
    }

    public static void printQueue(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();

        for (int num : arr) {
            queue.offer(num);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }
}
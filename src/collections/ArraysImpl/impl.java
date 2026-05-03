package collections.ArraysImpl;

import java.util.Arrays;
import java.util.Random;

public class impl {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] arr= new int[100000];
        Random rand = new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=rand.nextInt(0,100000);
        }
        Arrays.parallelSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);


        long durationInMillis = duration / 1000000;
        System.out.println("Execution time: " + durationInMillis + " ms");

    }
}

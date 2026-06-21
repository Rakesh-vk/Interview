package collections.Arrays.algorithms.Sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    // step 1 : compare adjacent elements and if [j] > [j+1] swap
    // step 2 : continue till n-i-1 index
    // time complexity : O(n^2)
    // space complexity : O(1)

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps happened, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Random rand= new Random();
        long startTime = System.nanoTime();
        int[] numbers= new int[100000];
        for(int i=0;i< numbers.length;i++){
            numbers[i]= rand.nextInt(1000000);
        }
        long endTimeForInsert = System.nanoTime();
        double durationInSeconds1 = (endTimeForInsert - startTime) / 1_000_000_000.0;
        System.out.println("time to insert : "+durationInSeconds1);
        bubbleSort(numbers);
        System.out.println();

        System.out.println(Arrays.toString(numbers));
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("time to sort : "+durationInSeconds);
    }
}
package collections.Arrays.algorithms.Sorting;

// 1.Divide the array until each subarray contains one element.
// 2.Recursively sort the left and right halves.
// 3.Merge the two sorted halves by comparing elements.
// 4.Use a temporary array during merging.
// 5.Copy merged elements back to the original array.
// Time complexity: O(n log n)
// space Complexity : O(n)
import java.util.Arrays;

public class MergeSort {

    // Recursively divide the array into two halves
    public static void mergeSort(int[] arr, int left, int right) {

        // Base case: array has only one element
        if (left >= right) {
            return;
        }

        // Find middle index
        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(arr, left, mid);

        // Sort right half
        mergeSort(arr, mid + 1, right);

        // Merge the two sorted halves
        merge(arr, left, mid, right);
    }

    // Merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {

        // Temporary array to store merged result
        int[] temp = new int[right - left + 1];

        // Pointer for left subarray
        int i = left;

        // Pointer for right subarray
        int j = mid + 1;

        // Pointer for temp array
        int k = 0;

        // Compare elements from both halves and copy smaller one
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy merged result back to original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {

        // Input array
        int[] arr = {1, 5, 2, 7, 3, 8, 4};

        // Sort the array
        mergeSort(arr, 0, arr.length - 1);

        // Print sorted array
        System.out.println(Arrays.toString(arr));
    }
}
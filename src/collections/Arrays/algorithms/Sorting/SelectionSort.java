package collections.Arrays.algorithms.Sorting;

public class SelectionSort {
    // step 1 : Find the smallest element in the unsorted part of the list.
    // step 2 : Swap it with the first element of the unsorted list.
    // step 3 : Repeat the process for the remaining unsorted part of the list
    // step 4 : Continue this process until the entire list is sorted
    // Time complexity : O(n^2)
    // space complexity O(1)
    void sort(int[] a)
    {
        int n = a.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {

            // Find the minimum element in unsorted array
            int min_idx = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx])
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    // main function
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int a[] = { 64, 25, 12, 22, 11 };

        ob.sort(a);

        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");

    }
}

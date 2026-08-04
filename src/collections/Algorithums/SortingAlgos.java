package collections.Algorithums;

public class SortingAlgos {

    public static void main(String[] args) {

        int[] arr = {5, 1, 4, 3};

        bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
    }

    /*
     * ============================================================
     * Bubble Sort
     * ============================================================
     *
     * HOW THE ALGORITHM WORKS
     * ------------------------------------------------------------
     *
     * Bubble Sort repeatedly compares adjacent elements and swaps
     * them if they are in the wrong order.
     *
     * After every pass, the largest element "bubbles up"
     * to its correct position at the end of the array.
     *
     * Example:
     *
     * 5 1 4 3
     *
     * Pass 1:
     * 1 5 4 3
     * 1 4 5 3
     * 1 4 3 5
     *
     * Largest element (5) is now at its correct position.
     *
     * Continue until the array becomes sorted.
     *
     * ------------------------------------------------------------
     * Time Complexity
     * ------------------------------------------------------------
     *
     * Best Case    : O(n²)
     * Average Case : O(n²)
     * Worst Case   : O(n²)
     *
     * (Can become O(n) if optimized using a swapped flag.)
     *
     * ------------------------------------------------------------
     * Space Complexity
     * ------------------------------------------------------------
     *
     * O(1)
     *
     * ============================================================
     */
    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Number of passes.
        // After every pass, one largest element reaches its correct position.
        for (int i = 0; i < n; i++) {

            // Compare adjacent elements.
            // Ignore already sorted elements at the end.
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if elements are in the wrong order.
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print sorted array.
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /*
     * ============================================================
     * Selection Sort
     * ============================================================
     *
     * HOW THE ALGORITHM WORKS
     * ------------------------------------------------------------
     *
     * Divide the array into two parts:
     *
     * 1. Sorted portion
     * 2. Unsorted portion
     *
     * During each iteration:
     *
     * Find the smallest element from the unsorted portion
     * and place it at the beginning.
     *
     * Example:
     *
     * 5 1 4 3
     *
     * Pass 1:
     * Find minimum = 1
     * Swap with first element
     *
     * 1 5 4 3
     *
     * Pass 2:
     * Find minimum = 3
     *
     * 1 3 4 5
     *
     * Continue until all elements are sorted.
     *
     * ------------------------------------------------------------
     * Time Complexity
     * ------------------------------------------------------------
     *
     * Best Case    : O(n²)
     * Average Case : O(n²)
     * Worst Case   : O(n²)
     *
     * ------------------------------------------------------------
     * Space Complexity
     * ------------------------------------------------------------
     *
     * O(1)
     *
     * ============================================================
     */
    public static void selectionSort(int[] arr) {

        int n = arr.length;

        // Move boundary of sorted portion.
        for (int i = 0; i < n - 1; i++) {

            // Assume current element is the minimum.
            int minIdx = i;

            // Search remaining array for actual minimum.
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Place smallest element at its correct position.
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }

        // Print sorted array.
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /*
     * ============================================================
     * Insertion Sort
     * ============================================================
     *
     * HOW THE ALGORITHM WORKS
     * ------------------------------------------------------------
     *
     * Similar to arranging playing cards in your hand.
     *
     * Assume the first element is already sorted.
     *
     * Pick one element at a time from the unsorted portion
     * and insert it into its correct position
     * inside the sorted portion.
     *
     * Example:
     *
     * 5 1 4 3
     *
     * Sorted | Unsorted
     *
     * 5 | 1 4 3
     *
     * Insert 1
     *
     * 1 5 | 4 3
     *
     * Insert 4
     *
     * 1 4 5 | 3
     *
     * Insert 3
     *
     * 1 3 4 5
     *
     * ------------------------------------------------------------
     * Time Complexity
     * ------------------------------------------------------------
     *
     * Best Case    : O(n)
     * Average Case : O(n²)
     * Worst Case   : O(n²)
     *
     * ------------------------------------------------------------
     * Space Complexity
     * ------------------------------------------------------------
     *
     * O(1)
     *
     * ============================================================
     */
    public static void insertionSort(int[] arr) {

        // Start from second element.
        // First element is already considered sorted.
        for (int i = 1; i < arr.length; i++) {

            // Current element to insert.
            int current = arr[i];

            // Last index of sorted portion.
            int j = i - 1;

            /*
             * Shift all larger elements one position to the right
             * to make space for the current element.
             */
            while (j >= 0 && arr[j] > current) {

                arr[j + 1] = arr[j];
                j--;
            }

            // Insert current element into its correct position.
            arr[j + 1] = current;
        }

        // Print sorted array.
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
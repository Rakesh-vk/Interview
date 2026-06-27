package collections.Arrays.algorithms.DutchNationalFlag;

public class sort0s1s2s {

    /*
     * ============================================================
     * Dutch National Flag Algorithm
     * ============================================================
     *
     * Problem:
     * ------------------------------------------------------------
     * Sort an array containing only 0s, 1s and 2s
     * in a single traversal.
     *
     * Example:
     *
     * Input:
     * 2 0 2 1 1 0
     *
     * Output:
     * 0 0 1 1 2 2
     *
     * ------------------------------------------------------------
     * HOW THE ALGORITHM WORKS
     * ------------------------------------------------------------
     *
     * Divide the array into four regions using three pointers.
     *
     *              low          mid          high
     *               |            |             |
     *               v            v             v
     *
     * ---------------------------------------------
     * | 0's | 1's | Unknown Elements | 2's |
     * ---------------------------------------------
     *
     * Initially:
     *
     * low = 0
     * mid = 0
     * high = n - 1
     *
     * Regions:
     *
     * 0 to low-1        -> All 0's
     *
     * low to mid-1      -> All 1's
     *
     * mid to high       -> Unknown elements
     *
     * high+1 to n-1     -> All 2's
     *
     * ------------------------------------------------------------
     * Rules
     * ------------------------------------------------------------
     *
     * Case 1:
     * arr[mid] == 0
     *
     * Swap arr[mid] with arr[low]
     *
     * low++
     * mid++
     *
     * ------------------------------------------------------------
     *
     * Case 2:
     * arr[mid] == 1
     *
     * Already in correct region.
     *
     * mid++
     *
     * ------------------------------------------------------------
     *
     * Case 3:
     * arr[mid] == 2
     *
     * Swap arr[mid] with arr[high]
     *
     * high--
     *
     * Do NOT increment mid.
     *
     * Reason:
     * The element swapped from the end has not been processed yet.
     *
     * ------------------------------------------------------------
     * Time Complexity
     * ------------------------------------------------------------
     *
     * O(n)
     *
     * Every element is processed at most once.
     *
     * ------------------------------------------------------------
     * Space Complexity
     * ------------------------------------------------------------
     *
     * O(1)
     *
     * ============================================================
     */

    public static void main(String[] args) {

        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sortColors(int[] arr) {

        // Pointer for next position of 0
        int low = 0;

        // Pointer for current element
        int mid = 0;

        // Pointer for next position of 2
        int high = arr.length - 1;

        /*
         * Continue until all unknown elements
         * have been processed.
         */
        while (mid <= high) {

            // Current element is 0.
            // Place it in the 0's region.
            if (arr[mid] == 0) {

                swap(arr, low, mid);

                low++;
                mid++;
            }

            // Current element is already in
            // the correct (1's) region.
            else if (arr[mid] == 1) {

                mid++;
            }

            // Current element is 2.
            // Move it to the end.
            else {

                swap(arr, mid, high);

                high--;

                /*
                 * Do NOT increment mid.
                 *
                 * The swapped element from the end
                 * is still unprocessed.
                 */
            }
        }
    }

    // Utility method to swap two elements.
    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
 * ============================================================
 * DRY RUN
 * ============================================================
 *
 * Input:
 *
 * arr = [2, 0, 2, 1, 1, 0]
 *
 * low = 0
 * mid = 0
 * high = 5
 *
 * ------------------------------------------------------------
 *
 * Step 1
 *
 * low = 0
 * mid = 0
 * high = 5
 *
 * arr[mid] = 2
 *
 * Swap(mid, high)
 *
 * 2 0 2 1 1 0
 * ↓           ↓
 *
 * 0 0 2 1 1 2
 *
 * high--
 *
 * low = 0
 * mid = 0
 * high = 4
 *
 * ------------------------------------------------------------
 *
 * Step 2
 *
 * arr[mid] = 0
 *
 * Swap(low, mid)
 *
 * 0 0 2 1 1 2
 *
 * low++
 * mid++
 *
 * low = 1
 * mid = 1
 * high = 4
 *
 * ------------------------------------------------------------
 *
 * Step 3
 *
 * arr[mid] = 0
 *
 * Swap(low, mid)
 *
 * 0 0 2 1 1 2
 *
 * low++
 * mid++
 *
 * low = 2
 * mid = 2
 * high = 4
 *
 * ------------------------------------------------------------
 *
 * Step 4
 *
 * arr[mid] = 2
 *
 * Swap(mid, high)
 *
 * 0 0 2 1 1 2
 *       ↓   ↓
 *
 * 0 0 1 1 2 2
 *
 * high--
 *
 * IMPORTANT:
 * Do NOT increment mid.
 *
 * Why?
 * Because the element swapped from the end
 * has not been processed yet.
 *
 * low = 2
 * mid = 2
 * high = 3
 *
 * ------------------------------------------------------------
 *
 * Step 5
 *
 * arr[mid] = 1
 *
 * 1 belongs in the middle.
 *
 * mid++
 *
 * low = 2
 * mid = 3
 * high = 3
 *
 * ------------------------------------------------------------
 *
 * Step 6
 *
 * arr[mid] = 1
 *
 * mid++
 *
 * low = 2
 * mid = 4
 * high = 3
 *
 * ------------------------------------------------------------
 *
 * Loop ends because:
 *
 * mid > high
 *
 * Final Array:
 *
 * 0 0 1 1 2 2
 *
 * ============================================================
 *
 * REVISION TRICK
 * ============================================================
 *
 * Maintain four regions:
 *
 * 0 ........ low-1      -> 0's
 * low ...... mid-1      -> 1's
 * mid ...... high       -> Unknown
 * high+1 ... n-1        -> 2's
 *
 * Three Rules:
 *
 * 0 → Swap(low, mid), low++, mid++
 *
 * 1 → mid++
 *
 * 2 → Swap(mid, high), high--
 *     (Don't increment mid)
 *
 * ============================================================
 */
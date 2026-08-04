package collections.Arrays.algorithms.Kadans;

/*
==========================================================
Algorithm Name:
Kadane's Algorithm (Maximum Subarray Sum)

----------------------------------------------------------
How it Works:
1. Traverse the array from left to right.
2. Keep adding the current element to a running sum (temp).
3. Update the maximum sum whenever the running sum becomes larger.
4. If the running sum becomes negative, discard it by resetting it to 0.
5. Continue until the end of the array. The maximum value obtained is the
   maximum subarray sum.

----------------------------------------------------------
Time Complexity:
- Best Case   : O(n)
- Average Case: O(n)
- Worst Case  : O(n)

Space Complexity:
- O(1)

----------------------------------------------------------
Revision Trick:
Think of carrying a bag of numbers.
If the bag's total becomes negative, throw it away and start with an empty bag,
because a negative sum can never help create a larger future sum.

==========================================================
*/

public class maxSubArraySum {

    public static void main(String[] args) {

        // Input array
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Find maximum subarray sum
        max(arr);
    }

    public static void max(int[] arr) {

        // Length of array
        int n = arr.length;

        // Stores the maximum subarray sum found so far
        int max = arr[0];

        // Stores the current running subarray sum
        int temp = 0;

        // Traverse every element of the array
        for (int i = 0; i < n; i++) {

            // Add current element to the running sum
            temp += arr[i];

            // Update maximum sum if current running sum is greater
            if (temp > max)
                max = temp;

            // If running sum becomes negative,
            // discard it and start a new subarray
            if (temp < 0)
                temp = 0;
        }

        // Print the maximum subarray sum
        System.out.println(max);
    }
}

/*
==========================================================
Dry Run

Input:
arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}

Initially:
max = -2
temp = 0

----------------------------------------------------------
i = 0
arr[i] = -2
temp = 0 + (-2) = -2
max = max(-2, -2) = -2
temp < 0 → temp = 0

----------------------------------------------------------
i = 1
arr[i] = 1
temp = 0 + 1 = 1
max = max(-2, 1) = 1

----------------------------------------------------------
i = 2
arr[i] = -3
temp = 1 + (-3) = -2
max = 1
temp < 0 → temp = 0

----------------------------------------------------------
i = 3
arr[i] = 4
temp = 0 + 4 = 4
max = max(1, 4) = 4

----------------------------------------------------------
i = 4
arr[i] = -1
temp = 4 + (-1) = 3
max = 4

----------------------------------------------------------
i = 5
arr[i] = 2
temp = 3 + 2 = 5
max = max(4, 5) = 5

----------------------------------------------------------
i = 6
arr[i] = 1
temp = 5 + 1 = 6
max = max(5, 6) = 6

----------------------------------------------------------
i = 7
arr[i] = -5
temp = 6 + (-5) = 1
max = 6

----------------------------------------------------------
i = 8
arr[i] = 4
temp = 1 + 4 = 5
max = 6

----------------------------------------------------------
Final Answer:
Maximum Subarray Sum = 6

Maximum Subarray:
{4, -1, 2, 1}

==========================================================
*/
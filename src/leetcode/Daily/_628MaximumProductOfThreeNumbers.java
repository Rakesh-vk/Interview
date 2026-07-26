package leetcode.Daily;

import java.util.Arrays;

// biggest product can come from max 3 elements or from first 2 and last 1 element, find them and find product then result. in this approach the TC is O(n log n) as we are sorting.
// to make it O(n) in one pass find the max 1,2,3 and min 1,2 find the product that is optimized approach
public class _628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] arr={-10,-10,1,2,3};
        System.out.println(maximumProductOptimized(arr));
    }
    // better Solution
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=Math.max((nums[n-1] * nums[n-2] * nums[n-3]),(nums[0] * nums[1] * nums[n-1]));
        return max;
    }
    //optimized
    public static int maximumProductOptimized(int[] nums) {
        int max1 = Integer.MIN_VALUE; // largest
        int max2 = Integer.MIN_VALUE; // second largest
        int max3 = Integer.MIN_VALUE; // third largest

        int min1 = Integer.MAX_VALUE; // smallest
        int min2 = Integer.MAX_VALUE; // second smallest

        for (int num : nums) {

            // Update three largest numbers
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            // Update two smallest numbers
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3,
                min1 * min2 * max1);

    }

}

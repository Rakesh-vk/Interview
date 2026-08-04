package leetcode.Daily;
// brute force solution is to sort the array and get the max 2 elements and find the product of them TC : O(n log n) for sorting.
// Optimized solution is to find the max 2 elements in one pass then find the products and return it TC : O(n) SC O(1).
public class _1464MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        int[] arr={3,4,5,2};
        System.out.println(maxProduct(arr));
    }
    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}

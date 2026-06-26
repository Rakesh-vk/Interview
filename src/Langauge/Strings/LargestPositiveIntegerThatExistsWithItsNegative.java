package Langauge.Strings;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[] arr= {-10,8,6,7,-2,-3};
        System.out.println(findMaxK(arr));
    }
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int start=0,end=nums.length-1;
        while(start<end) {
            if (Math.abs(nums[start]) == nums[end]) {
                return nums[end];
            } else if (Math.abs(nums[start]) > nums[end]) {
                start++;
            } else {
                end--;
            }
        }
        return -1;
    }
}

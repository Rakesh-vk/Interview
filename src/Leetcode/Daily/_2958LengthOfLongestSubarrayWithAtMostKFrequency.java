package Leetcode.Daily;

import java.util.HashMap;

public class _2958LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        int[] nums={1,2,1,2,1,2,1,2};
        int k=1;
        System.out.println(maxSubarrayLength(nums,k));
    }
        public static int maxSubarrayLength(int[] nums, int k) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            int left = 0;
            int maxLength = 0;

            for (int right = 0; right < nums.length; right++) {

                freq.put(nums[right],
                        freq.getOrDefault(nums[right], 0) + 1);

                while (freq.get(nums[right]) > k) {
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }

}

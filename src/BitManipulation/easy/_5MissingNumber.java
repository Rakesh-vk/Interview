package BitManipulation.easy;

public class _5MissingNumber {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;
        for (int i = 0; i < n; i++) {
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }
}

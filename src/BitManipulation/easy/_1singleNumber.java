package BitManipulation.easy;

public class _1singleNumber {
    public static void main(String[] args) {
        // here we are using the property of a^a=0
        // if we XOR a number with itself then the result will be zero
        // when we XOR all elements of nums, duplicate numbers cancel out them self.
        int[] nums={3,2,3};
        int result=0;
        for(int num:nums){
            result= result ^num;
        }
        System.out.println(result);
    }
}

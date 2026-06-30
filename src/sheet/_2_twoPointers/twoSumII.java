package sheet._2_twoPointers;

import java.util.Arrays;

public class twoSumII {
    public static void main(String[] args) {
        int numbers[] = {2,7,11,15}, target = 9;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
            int i=0,j=numbers.length-1;
            while(i<j){
                int sum = numbers[i]+numbers[j];
                if(sum == target){
                    return new int[]{i+1,j+1};
                }
                else if(sum >target){
                    j--;
                }
                else i++;
            }
            return new int[] {-1,-1};

    }
}

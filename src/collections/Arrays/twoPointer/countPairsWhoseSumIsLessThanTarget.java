package collections.Arrays.twoPointer;

import java.util.Arrays;
import java.util.List;

public class countPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-6,2,5,-2,-7,-1,3);
        int target=2;
        System.out.println(countPairs(list,target));
    }
    public static int countPairs(List<Integer> nums, int target){
        int count = 0;
        int n  = nums.size();
        for (int i = 0; i < n; i++) {
            int ele = nums.get(i);
            for (int j = i + 1; j < n; j++) {
                if (ele + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;

    }
}

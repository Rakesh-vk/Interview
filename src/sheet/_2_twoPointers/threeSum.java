package sheet._2_twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));


    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> res= new ArrayList<>();
       for(int i=0;i<n;i++) {
           if (i > 0 && nums[i] == nums[i - 1])
               continue;
           int j=i+1;
           int k=nums.length-1;
           while(j<k){
               int target= nums[i]+nums[j]+nums[k];
               if(target>0){
                   k--;
               }
               else if(target < 0){
                   j++;
               }
               else {
                   res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   j++;
                   while(j>0 && nums[j]== nums[j-1]){
                       j++;
                   }
               }
           }
       }
        return res;
    }
}

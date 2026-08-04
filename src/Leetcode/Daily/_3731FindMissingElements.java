package Leetcode.Daily;

import java.util.*;

public class _3731FindMissingElements{
    public static void main(String[] args) {
        int[] nums={1,5};
        System.out.println(findMissingElements(nums));

    }
    public static List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set= new HashSet<>();
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
            max= Math.max(max,num);
            set.add(num);
        }
        List<Integer> result= new ArrayList<>();
        for(int i=min;i<max;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;

    }
}
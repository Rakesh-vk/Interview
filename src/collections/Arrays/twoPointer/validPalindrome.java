package collections.Arrays.twoPointer;

import java.util.Arrays;
import java.util.List;

public class validPalindrome {

    public static void main(String[] args) {

//        String sb="A man, a plan, a canal: Panama";
//        System.out.println(isValid(sb));
        List<Integer> nums= Arrays.asList(-1,1,2,3,1);
        int target =2;
//        System.out.println(countPairs(nums,target));
    }
    public static boolean isValid(String s){
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
//    public static int countPairs(List<Integer> nums, int target) {
//        int i =0,n=nums.size()-1,j=n,count=0;
//        while(i<j){
//            if(nums.get(i)+nums.get(j)==target){
//                count++;
//            }
//            else if(nums.get(i)+nums.get(j)>target){
//                j--;
//            }
//            else if{
//                i++;
//            }
//        }
//        return count;
//    }
}

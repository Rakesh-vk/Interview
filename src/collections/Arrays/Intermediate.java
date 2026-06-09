package collections.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Intermediate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,7};
        int target=10;
//        twoSum(arr,target);
        int[] arr1={1,2,2,3,4,5,5};
//        removeDuplicateInPlace(arr1);
        int[] heights={1,8,6,2,5,4,8,3,7};
//        containerWithMostWater(heights);
    }
    public static void containerWithMostWater(int[] heights){
        int left=0,right=heights.length-1;
        int max=0;
        while(left<right){
            int curHeight=Math.min(heights[left],heights[right]);
            int curWidth=right-left;
            int curArea=curHeight*curWidth;
            max = Math.max(curArea,max);
            if(heights[left]<heights[right]) left++;
            else right--;
        }
        System.out.println("max area = "+max);
    }
    public static void removeDuplicateInPlace(int[] arr){
        int n=arr.length;
        if(n<=1) printArray(arr);

        int idx=1;
        for(int i=1;i<n;i++){
            if(arr[i] != arr[i-1]){
                arr[idx++]=arr[i];
            }
        }
        printArray(arr);


    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void twoSum(int[] arr,int target){
        Map<Integer,Integer> map= new HashMap<>();
        int n= arr.length;
        for(int i=0;i<n;i++){
            int rem= target-arr[i];
            if(!map.containsKey(rem)){
                map.put(arr[i],i);
            }
            else System.out.println(map.get(rem)+" "+i);
        }

    }
}

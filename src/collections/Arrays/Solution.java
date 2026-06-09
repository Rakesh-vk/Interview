package collections.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
//        printAllSubarrays(arr);
//        printAllSubarraySum_RunningSum(arr);
//        printAllPrefix(arr);
//        printAllPrefixSum(arr);
    }

    public static void printAllSubarrays(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void printAllSubarraySum_RunningSum(int[] arr){
        // Running Sum
        // time complexity : O(n^2)
        // space complexity : O(1)
        int n= arr.length;
        for(int i=0;i<n;i++){
            int cs=0;
            for(int j=i;j<n;j++){
                cs+=arr[j];
                System.out.println(cs);
            }
        }
    }
    public static void printAllPrefix(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }

    }
    public static void printAllPrefixSum(int[] arr){
        int n=arr.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            System.out.println(sum);
        }
    }

}

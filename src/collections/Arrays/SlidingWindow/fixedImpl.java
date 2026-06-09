package collections.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class fixedImpl {
    public static void main(String[] args) {
        int[] arr={2,1,5,1,3,2};
        int k=3;
        subarraySumOfLengthK(arr,k);
//        maxSumSubarrayOfSizeK(arr,k);
//        countSubArrayWhereCurrentSumIsEqualsToThreshold(arr,5);
//        countSubArrayWhereCurrentSumIsLessToThreshold(arr,5);
//        countSubArrayWhereCurrentSumIsGraterToThreshold(arr,5);
        int arr1[]={1,5,4,2,9,9,9},k1=3;
//        maximumSumOfDistinctSubarraysWithLengthK(arr1,k1);

    }
    public static void maximumSumOfDistinctSubarraysWithLengthK(int[] arr, int k) {

        int i = 0;
        long currentSum = 0;
        long maxSum = 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {

            currentSum += arr[j];

            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);

            // maintain window size k
            if (j - i + 1 > k) {

                freq.put(arr[i], freq.get(arr[i]) - 1);

                if (freq.get(arr[i]) == 0) {
                    freq.remove(arr[i]);
                }

                currentSum -= arr[i];

                i++;
            }

            // valid window
            if (j - i + 1 == k && freq.size() == k) {

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        System.out.println(maxSum);
    }
    public static void NumberOfSubarrayOfSizeKAndAverageGraterThanOrEqualToThreshold(int[] arr, int k,int threshold){
        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int count = 0;

        if (windowSum >= k * threshold) {
            count++;
        }

        // slide window
        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];
            windowSum -= arr[i - k];

            if (windowSum >= k * threshold) {
                count++;
            }
        }

        System.out.println(count);
    }
    public  static void countSubArrayWhereCurrentSumIsEqualsToThreshold(int[] arr,int k){
        // running sum
        int count=0,n=arr.length;
        for(int i=0;i<n;i++){
            int cs=0;
            for(int j=i;j<n;j++){
                cs+=arr[j];
                if(cs==k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public  static void countSubArrayWhereCurrentSumIsGraterToThreshold(int[] arr,int k){
        // running sum
        int count=0,n=arr.length;
        for(int i=0;i<n;i++){
            int cs=0;
            for(int j=i;j<n;j++){
                cs+=arr[j];
                if(cs>k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public  static void countSubArrayWhereCurrentSumIsLessToThreshold(int[] arr,int k){
        // running sum
        int count=0,n=arr.length;
        for(int i=0;i<n;i++){
            int cs=0;
            for(int j=i;j<n;j++){
                cs+=arr[j];
                if(cs<k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void maxSumSubarrayOfSizeK(int[] arr, int k) {
        int currentSum = 0, n = arr.length-1;
        int i = 0, j = 0;
        while (j < n) {
            while (j - i != k) {
               currentSum+=arr[j];
                j++;
            }
            System.out.println("sum : "+currentSum);
            currentSum-=arr[i];
            i++;
            j++;
            currentSum+=arr[j];

        }
    }
    public static void printArray(int[] arr,int st,int end){
        for(int i=st;i<end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void subarraySumOfLengthK(int[] arr, int k)   {
        int i = 0, j = 0;
        int n = arr.length;
        int windowSum = 0;
        while (j < n) {
            // expand window
            windowSum += arr[j];
             if (j - i + 1 == k) {
                // print current window sum
                System.out.println(windowSum);
                // slide window
                windowSum -= arr[i];
                i++;
            }
             j++;
        }
    }
}

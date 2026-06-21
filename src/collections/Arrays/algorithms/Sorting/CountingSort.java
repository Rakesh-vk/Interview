package collections.Arrays.algorithms.Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr= {4,2,2,8,3,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        // find the maximum
        // create a frequency array
        // count frequency
        // reconstruct the array
        // time complexity : O(n+K)
        // space complexity : O(k)

        // find the maximum element
        int max=0;
        for(int i:arr){
            if(max<i)max=i;
        }

        // create a frequency array
        int[] freq= new int[max+1];

        // count frequency
        for(int num : arr){
            freq[num]++;
        }

        // reconstruct array
        int k=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                arr[k++] = i;
                freq[i]--;
            }
        }
    }
}

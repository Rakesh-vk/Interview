package collections.Arrays.algorithms.DutchNationalFlag;

import java.util.Arrays;

public class sort0s1s2s {
    public static void main(String[] args) {
        int[] arr={1,2,1,0,1,2,0,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int low=0,n=arr.length,j=n-1;
        int mid=0;
        while(mid <= j){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, j);
                j--;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
}

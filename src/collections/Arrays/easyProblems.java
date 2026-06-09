package collections.Arrays;

import java.util.Arrays;

public class easyProblems {
    public static void main(String[] args) {
        int[] arr={2,4,6,9};
        ifArraySorted(arr);
        int[] arr1={0,1,0,1,1,0,0,0,1};
        sort0sAnd1s(arr1);
        String str= "hello HiaababA";
        sortString(str);

    }
    public static void sortString(String str){
        System.out.println();
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);


    }
    public static void sort0sAnd1s(int[] arr){
        int l=0,r=arr.length-1;
        while(l<r){
            if(arr[l]==0){
                l++;
            }else if(arr[l]==1 && arr[r]==0){
                int temp = arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++;
                r--;
            }else {
                r--;
            }
        }
        printArray(arr);
    }
    public static void printArray(int[] arr){
        Arrays.stream(arr).forEach(x->System.out.print(x+" "));
    }
    public static void ifArraySorted(int[] arr){
        int n= arr.length;
        if(arr[0]>arr[n-1]){
            for(int i=0;i<n-1;i++){
                if(arr[i]<arr[i+1]){
                    System.out.println("array is not sorted");
                    return ;
                }
            }

        }
        else{
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    System.out.println("array is not sorted");
                    return ;
                }
            }
        }
        System.out.println("Array is sorted");

    }

}

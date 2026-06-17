package collections.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Impl {
    public static void main(String[] args) {
        int[] arr={10,1,2,0,4,-1};
//        LinearSearch(arr,4);
//        maxOfArray(arr);
//        minOfArray(arr);
//        secondMax(arr);
//        printAllSubArrays(arr);
//        printMaxOfAllSubArray(arr);
//        printMaxOfAllSubArrayOptimized(arr);
//        printMinOfAllSubArray(arr);
//        printMinOfAllSubArraysOptimized(arr);
//        allSubArraySum(arr);
//        printAllSubArraySumOptimized(arr);
//        subArrayContainingZero(arr);
//        subArrayContainingZeroOptimized(arr);
//        printAllPrefix(arr);
        // practice
//        selectionSortArray(arr);
//        selectionInDescendingOrder(arr);
//          bubbleSort(arr);
//            InsertionSort(arr);
//        printArray(mergeSort(arr));
//        int[] nums1={4,9,5},nums2={9,4,9,8,4};
//        printArray(intersection(nums1,nums2));
        int[] arr2={1,0,2,1,2};
//        printAllSubarrayOfLengthK(arr2,2);
        printSumSubarrayOfLengthK(arr2,2);
//        runningSum(arr2);
    }
    public static void printSumSubarrayOfLengthK(int[] arr,int k){
        int i=0,j=0,n=arr.length;
        while(j<n){
            if(j-i+1==k){
                System.out.println(print1(arr,i,j));
                i++;
            }
            j++;
        }
    }
    public static int print1(int[] arr,int start,int end){
        int sum=0;
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
            sum+=arr[i];
        }

        return sum;
    }
    public static void printAllSubarrayOfLengthK(int[] arr,int k){
        int i=0,j=0,n=arr.length;
        while(j<n){
            if(j-i+1==k){
                print(arr,i,j);
                i++;
            }
             j++;
        }
    }
    public static void print(int[] arr,int start,int end){
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void LinearSearch(int[] arr,int target){
        // linear search is searching through the unsorted array
        // iterate through each element one by one and compare it with target
        // if yes print it
        // if no then continue till end of array
        int n=arr.length-1;
        for(int i=0;i<=n;i++){
            if(arr[i]==target){
                System.out.printf("target is found at %d position%n", i+1);
            }
        }
    }
    public static void maxOfArray(int[] arr){
        //take a variable and set it to Integer.MIN_VALUE;
        // iterate through array
        // compare one by one
        // if current element is grater than max assign current element to max
        // else continue till end.
        System.out.println("\nMax of SubArray");
        int n=arr.length-1;
        for(int i=0;i<=n;i++){

            for(int j=i;j<=n;j++){
                int max=0;
                for(int k=i;k<=j;k++){
                    System.out.print(" "+arr[k]);
                    max= Math.max(arr[k], max);
                }
                System.out.println(" = "+max);
            }
        }
    }
    public static void minOfArray(int[] arr){
        //take a variable and set it to Integer.MAX_VALUE;
        // iterate through array
        // compare one by one
        // if current element is less than max assign current element to Min
        // else continue till end.
        System.out.println("\n Minimum of all subArrays");
        int n= arr.length-1;
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    min= Math.min(arr[k], min);
                }
                System.out.print(" = "+min);
                System.out.println();
            }
        }
    }
    public static void secondMax(int[] arr){
        // take 2 pointers one to point to the highest element assigned to Integer.MIN_VALUE, another is second-highest element pointing to Integer.MIN_VALUE.
        // iterate through array
        // if current element is grater than the highest element then second-highest = highest and highest = current element
        // if current element is less than the highest then check if the current element is grater than second element if yes then second-highest= current element

        System.out.println("Second maximum element\n");
        int n=arr.length-1,max=0,sMax=0;
        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
            if(arr[i]>max){
                sMax=max;
                max=arr[i];
            }
            else if(arr[i]<max && arr[i]>sMax){
                sMax=arr[i];
            }
        }
        System.out.println("the Second maximum element is = "+sMax);

    }
    public static void printAllSubArrays(int[] arr){
        // printing all subarray using the nested loops
        // here I am using 3 nested loops
        // time complexity : O(n^3) because of 3 nested loops
        // space complexity : O(1)
        System.out.println("All SubArrays");
        int n= arr.length-1;
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                for(int k=i;k<j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void printMaxOfAllSubArray(int[] arr){
        // same as printing all the subarrays but find the max
        System.out.println("printing the max of subarray");
        int n=arr.length-1;
        for(int i=0;i<=n;i++){
            for(int j=i;j<=n;j++){
                int max=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    max=arr[k]>max?arr[k]:max;
                }
                System.out.println(" = "+max);
            }
        }
    }
    private static int[] mergeSort( int[] arr ) {
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

// copyOfRange: makes a copy of the original array with the defined range [ exclusive ]
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);

    }
    private static void runningSum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            System.out.print(sum);
        }

    }
    private  static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }
    public static void MergeSort(){}
    public static void InsertionSort(int[] arr){
        int n= arr.length;
        for(int i=1;i<n;++i){
            int key= arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }

        printArray(arr);
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;

        printArray(arr);

        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // optimization
            if (!swapped) {
                break;
            }
        }
        printArray(arr);
    }
    public static void printArray(int[] arr){
        System.out.println();
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void selectionSortArray(int[] arr){
        // find the smallest element in array from i to n-1 and swap it with ith element
        int n= arr.length;
        printArray(arr);
        System.out.println();
        for(int i=0;i<n-1;i++){
            int min=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]= temp;
        }
        printArray(arr);
    }
    public static void selectionInDescendingOrder(int[] arr){
        int n=arr.length-1;
        printArray(arr);
        for(int i=0;i<n-1;i++){
            int max=i;
            for(int j=i;j<n;j++){
                if(arr[j]>arr[max]){
                    max=j;
                }
            }
            int temp = arr[max];
            arr[max]= arr[i];
            arr[i]=temp;
        }
        printArray(arr);

    }
    public static void subArrayContainingZero(int[] arr){
        System.out.println("printing the subarray containing zeros");
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                boolean flag=false;
                ArrayList<Integer> list= new ArrayList<>();
                for(int k=i;k<=j;k++){
                    list.add(arr[k]);
                    if(arr[k]==0){
                        flag=true;
                    }
                }
                if(flag){
                    System.out.println(list);
                }
            }
        }
    }
    public static void subArrayContainingZeroOptimized(int[] arr){
        System.out.println("subArrays containing zeros optimized");
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=i;j<n;j++){
                if(arr[j]==0){
                    flag=true;
                }
                if (flag){
                    for(int k=i;k<=j;k++){
                        System.out.print(arr[k]+" ");
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
    public static void allSubArraySum(int arr[]){
        System.out.println("All SubArrays sum");
        int n= arr.length-1;
        for(int i=0;i<=n;i++){
            for (int j=i;j<=n;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];
                }
                System.out.print(" = "+sum);
                System.out.println();
            }

        }
    }
    public static void printAllSubArraySumOptimized(int[] arr){
        System.out.println("printing the subarray sum Optimized O(n^2)");
        int n=arr.length;
        for(int i=0;i<n;i++){
            int cs=0;
            for(int j=i;j<n;j++){
                cs+=arr[j];
                System.out.println(cs);
            }
        }
    }
    // prefix means all the subarray starting with zero
    public static void printAllPrefix(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
                int sum=0;
            for(int j = 0; j <= i; j++){
                sum+=arr[j];
                System.out.print(arr[j] + " ");
            }
            System.out.println(" = "+sum);
        }

    }
    public static void printMaxOfAllSubArrayOptimized(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < n; j++){
                max = Math.max(max, arr[j]);
                System.out.println(max);
            }
        }
    }
    public static void printMinOfAllSubArray(int[] arr){
        System.out.println("Minimum of all SubArray");
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    min=arr[k]<min?arr[k]:min;
                }
                System.out.println(" = "+min);
            }
        }
    }
    public static void printMinOfAllSubArraysOptimized(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min= Math.min(min,arr[j]);
                System.out.println(min);
            }
        }
    }
    public static  int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,n=nums1.length,m=nums2.length;
        ArrayList<Integer> arr= new ArrayList<>();
        while(i<n && j<m){
            System.out.println(nums1[i]+" "+nums2[j]);
            if(nums1[i] == nums2[j]){
                arr.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]< nums2[j]){
                i++;
            }
            else j++;
        }
        System.out.println(arr);
        int[] result= new int[arr.size()];
        i=0;
        for(int ar:arr){
            result[i++]=ar;
        }
        printArray(result);
        return result;
    }


}

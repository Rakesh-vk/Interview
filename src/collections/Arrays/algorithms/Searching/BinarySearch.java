package collections.Arrays.algorithms.Searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,7,9};
        int target=5;
        System.out.println(search(arr,target));
    }
    public static int search(int[] arr,int target){
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else { end = mid -1;}
        }
        return -1;
    }
}

package collections.Arrays.algorithms.Searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={1,2,4,2,5,2};
        int target=51;
        System.out.println(search(arr,target));
    }
    public static int search(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}

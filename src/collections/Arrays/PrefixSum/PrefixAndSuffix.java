package collections.Arrays.PrefixSum;

public class PrefixAndSuffix {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8};
//        prefixSum(arr);
//        System.out.println();
        int[] arr1= {1,2,3,4,5,6,7,8};
        suffixSum(arr1);
    }
    public static void suffixSum(int[] arr){
        for(int i=arr.length-2;i>=0;i--){
            arr[i]=arr[i]+arr[i+1];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void prefixSum(int[] arr){
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}

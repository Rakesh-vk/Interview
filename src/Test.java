import java.util.HashMap;

class Test{
    public static void main(String[] args) {
        int[] arr={100,200,300,400};
        int k=1;
        System.out.println(maxSubarraySum(arr,k));


    }
    public static  int maxSubarraySum(int[] arr, int k) {
        int maxSum=0;
        int n=arr.length;
        int i=0;
        int j=0;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            if(j-i+1==k){
                maxSum = Math.max(sum,maxSum);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return maxSum;

    }
}
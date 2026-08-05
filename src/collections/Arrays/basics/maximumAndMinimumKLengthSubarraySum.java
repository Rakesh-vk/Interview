package collections.Arrays.basics;

public class maximumAndMinimumKLengthSubarraySum {
    public static void main(String[] args) {
        int[] arr={2, 1, 5, 1, 3, 2};
        int k=3;
        solution(arr,k);
    }
    public static void solution(int[] arr,int k){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=arr.length;
        int sum=0;
        int i=0;
        for(int j=0;j<n;j++){
            sum+=arr[j];
            if(j-i+1==k){
                min=Math.min(min,sum);
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
            }
        }
        System.out.println("min : "+min);
        System.out.println("max : "+max);
    }
}

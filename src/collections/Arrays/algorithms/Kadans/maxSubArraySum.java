package collections.Arrays.algorithms.Kadans;

public class maxSubArraySum {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        max(arr);
    }
    public static void max(int[] arr){
        int n=arr.length;
        int max=arr[0],temp=0;
        for(int i=0;i<n;i++){
            temp+=arr[i];
            if(temp>max) max=temp;

            if(temp <0) temp =0;
        }
        System.out.println(max);
    }

}

package collections.Arrays.algorithms.Kadans;

public class minSubArraySum {
    public static void main(String[] args) {
        int[] arr={3,-2,1,2,3};
        min(arr);
    }
    public static void min(int[] arr){
        int n=arr.length;
        int min=arr[0],temp=0;
        for(int i=0;i<n;i++){
            temp+=arr[i];
            if(temp<min) min=temp;

            if(temp >0) temp =0;
        }
        System.out.println(min);
    }
}

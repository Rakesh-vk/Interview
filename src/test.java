import java.util.*;

public class test {
    public static void main(String[] args) {
        int arr[]={1,1,1};
        System.out.println(SubarraySumEqualsK(arr,2));
    }
    public static int SubarraySumEqualsK(int[] arr,int k){
        int result=0;
        int i=0,j=0;
        int sum=0;
        int n=arr.length;
        while (j<n){
            sum+=arr[j];
            if(j-i+1==k){
                result++;
                sum-=arr[i];
                i++;
            }
            j++;
        }

        return result;
    }


}


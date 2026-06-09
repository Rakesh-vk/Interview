import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*input =[1,2,5,10] k=2;
            observations
            1,2 =3
            2,5 = 7
            5, 10 = 15
            output = 15

            approach

         */
//        int[] arr={1,2,5,10,2,20};
//        int i=0,j=0,sum=0,maxsum=0,k=2;
//        int n=arr.length;
//        while(j<n){
//            sum+=arr[j];
//            if(j-i+1==k){ // to check the valid condition
//                maxsum=Math.max(maxsum,sum); // if valid then capture the current max;
//                sum-=arr[i];
//                i++;
//            }
//            j++;
//        }
//        System.out.println(maxsum);

//        given, array with  positive integers, count number of subarrays where ss >= t
            int target=5,c1=0;
            int[] arr={1,1,2,3,5};
            int n= arr.length;
            int i=0,j=0,cs=0;
            while(j<n){
                cs+=arr[j];
                while(cs>=target){
                    c1++;
                    cs-=arr[i];
                    i++;
                }
                j++;

            }
        System.out.println(c1);

    }


}


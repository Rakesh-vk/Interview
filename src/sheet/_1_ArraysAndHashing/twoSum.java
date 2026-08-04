package sheet._1_ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int target=13;
        find(arr,target);
    }
    public static void find(int[] arr, int target){
        Map<Integer,Integer> map= new HashMap<>();
        int n= arr.length;
        for(int i=0;i<n;i++){
            int rem = target-arr[i];
            if(map.containsKey(rem)) {
                System.out.println(" the idx are : "+map.get(rem)+" "+i);
                return ;
            }
            map.put(arr[i],i);
        }
    }
}

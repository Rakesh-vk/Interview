package collections.Arrays.twoPointer;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(bruteForce(arr));

    }

    public static List<List<Integer>> bruteForce(int[] arr){
        Set<List<Integer>> set= new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        set.add(temp);

                    }
                }
            }
        }
        return set.stream().toList();
    }
}

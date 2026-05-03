package practice.basics;

import java.util.ArrayList;
import java.util.List;

public class intersectionOfTwoSortedArrays {
    public static List<Integer> intersection(int[] a,int[] b){
        List<Integer> res= new ArrayList<>();
        int i=0,j=0;
        Integer last=null;

        while(i<a.length && j<b.length){
            if(a[i]<b[j])i++;
            else if(a[i]>b[j])j++;
            else{
                if(last == null || last!=a[i]){
                    res.add(a[i]);
                    last=a[i];
                }
                i++;j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] x={1,2,2,3,5,7};
        int[] y={2,2,4,5,6,7,7};
        System.out.println("Intersection : "+intersection(x,y));
    }
}

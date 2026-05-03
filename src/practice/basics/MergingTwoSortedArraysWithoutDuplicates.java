package practice.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MergingTwoSortedArraysWithoutDuplicates {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7};
        int[] arr2={2,3,6,7,8};

        Set<Integer> set=new TreeSet<>();
        for(int n:arr1)set.add(n);
        for(int n:arr2)set.add(n);

        System.out.println("Merged array: "+set);
    }
}

package Streams;

import java.util.Arrays;
import java.util.HashSet;

public class _1findDuplicateElements {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,2,4};
        HashSet<Integer> set= new HashSet<>();
        Arrays.stream(arr).filter(n-> !set.add(n)).forEach(System.out::println);
    }
}

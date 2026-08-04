package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _4PartitionEvenAndOddNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 1, 6, 9, 4, 3};
        Map<Boolean, List<Integer>> result
                = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even: " + result.get(true));
        System.out.println("Odd : " + result.get(false));
    }
}

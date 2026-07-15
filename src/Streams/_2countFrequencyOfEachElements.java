package Streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _2countFrequencyOfEachElements {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3,2,4,1,4,3};
        String string = Arrays.stream(arr).boxed().
                collect(Collectors.groupingBy(Function.identity()
                        , Collectors.counting())).toString();
        System.out.println(string);
    }
}

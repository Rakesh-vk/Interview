package practice.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class formattingListOfIntegerintoaCommaSeperatedString
{
    public static void main(String[] args) {
        List<Integer> arr= Arrays.asList(1,2,3,4,5);
        String collect = arr.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);

    }
}

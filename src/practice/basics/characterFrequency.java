package practice.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class characterFrequency {
    public static void main(String[] args) {
        String input="programming";
        Map<Character,Integer> freq= new HashMap<>();
        for(char c:input.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        System.out.println("character frequencies : "+ freq);

        Map<Character, Long> collect = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(collect);
    }
}

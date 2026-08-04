package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class interview1_1 {
    public static void main(String[] args) {
        Map<String,Integer> map= new HashMap<>();
        map.put("aaa",40);
        map.put("bbb",10);
        map.put("ccc",30);
        map.put("ddd",20);

        // sort this map based on natural sorting order based on values using streams
        // get the 2nd highest values

        Optional<Map.Entry<String, Integer>> first = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).skip(1).findFirst();
        System.out.println(first.get());


    }
}

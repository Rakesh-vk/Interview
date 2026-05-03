package practice.basics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LongestBookTitle {
    public static String longest(List<String> titles){
        if(titles==null|| titles.isEmpty()) return "";
        String best="";
        for(String t:titles){
            if(t!=null && t.length()>best.length()){
                best=t;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        List<String> titles= Arrays.asList("Dune","Clean code","Introduction to Algorithms");
        System.out.println(longest(titles));

        String best= titles.stream()
                .filter(Objects::nonNull)
                .max(java.util.Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(best);
    }
}

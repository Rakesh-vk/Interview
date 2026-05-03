package practice.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class vowelCount {
    public static final Set<Character> Vowels= new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public static int countVowels(String s){
        if(s==null) return 0;
        int count=0;
        for(char c:s.toLowerCase().toCharArray()){
            if(Vowels.contains(c)) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        String sentence="Data analysis is awesome!";
        System.out.println("Vowel count: "+countVowels(sentence));
    }
}

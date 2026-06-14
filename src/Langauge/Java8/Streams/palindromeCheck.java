package Langauge.Java8.Streams;

import java.util.stream.IntStream;

public class palindromeCheck {
    public static void main(String[] args) {
        String name="hello";
        boolean b = IntStream.range(0, name.length() / 2)
                .allMatch(i -> name.charAt(i) == name.charAt(name.length() - i - 1));
        System.out.println(b);
    }
}

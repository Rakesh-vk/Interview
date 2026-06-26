package Langauge.Strings;

public class StringFunctionsDemo {

    public static void main(String[] args) {

        String str = " Hello Java World ";
        String str2 = "hello java world";

        // Returns the length of the string.
        System.out.println(str.length());                    // 18

        // Returns the character at the specified index.
        System.out.println(str.charAt(1));                   // H

        // Returns substring from the given index.
        System.out.println(str.substring(7));                // Java World

        // Returns substring between beginIndex and endIndex-1.
        System.out.println(str.substring(7, 11));            // Java

        // Concatenates another string.
        System.out.println("Hello".concat(" Java"));         // Hello Java

        // Checks if the string contains a substring.
        System.out.println(str.contains("Java"));            // true

        // Compares two strings (case-sensitive).
        System.out.println("Java".equals("Java"));           // true

        // Compares two strings (case-insensitive).
        System.out.println("Java".equalsIgnoreCase("JAVA")); // true

        // Lexicographically compares two strings.
        System.out.println("abc".compareTo("abd"));          // -1

        // Lexicographically compares ignoring case.
        System.out.println("abc".compareToIgnoreCase("ABC"));// 0

        // Checks if the string starts with the given prefix.
        System.out.println(str.startsWith(" "));             // true

        // Checks if the string ends with the given suffix.
        System.out.println(str.endsWith(" "));               // true

        // Returns the first occurrence of a character/string.
        System.out.println(str.indexOf("Java"));             // 7

        // Returns the last occurrence of a character/string.
        System.out.println("banana".lastIndexOf('a'));       // 5

        // Checks if the string is empty.
        System.out.println("".isEmpty());                    // true

        // Checks if the string is empty or contains only whitespaces (Java 11+).
        System.out.println("   ".isBlank());                 // true

        // Converts all characters to uppercase.
        System.out.println(str.toUpperCase());               // HELLO JAVA WORLD

        // Converts all characters to lowercase.
        System.out.println(str.toLowerCase());               // hello java world

        // Removes leading and trailing spaces.
        System.out.println(str.trim());                      // Hello Java World

        // Removes leading/trailing Unicode whitespaces (Java 11+).
        System.out.println(str.strip());                     // Hello Java World

        // Replaces all occurrences of a character.
        System.out.println("banana".replace('a', 'o'));      // bonono

        // Replaces all occurrences of a substring.
        System.out.println("I like Java".replace("Java", "Python"));

        // Replaces all matches of a regular expression.
        System.out.println("a1b2c3".replaceAll("\\d", "")); // abc

        // Replaces the first regex match.
        System.out.println("a1b2c3".replaceFirst("\\d", "X"));// aXb2c3

        // Splits the string into an array.
        String[] arr = "A,B,C".split(",");
        for (String s : arr)
            System.out.println(s);

        // Joins multiple strings using a delimiter.
        System.out.println(String.join("-", "A", "B", "C")); // A-B-C

        // Checks if the string matches a regex.
        System.out.println("12345".matches("\\d+"));         // true

        // Repeats the string n times (Java 11+).
        System.out.println("Hi".repeat(3));                  // HiHiHi

        // Returns the pooled string reference.
        System.out.println("Java".intern());

        // Converts the string into a character array.
        char[] chars = "Java".toCharArray();
        for (char c : chars)
            System.out.print(c + " ");
        System.out.println();

        // Converts the string into a byte array.
        byte[] bytes = "Java".getBytes();
        for (byte b : bytes)
            System.out.print(b + " ");
        System.out.println();
    }
}
/*public class test3 {
}
    Write a Java function that takes an array of strings and a reference string as input. The function should return a new array where each string is reversed only if it is an anagram of the reference string. If a string is not an anagram of the reference string, it should remain unchanged. You are not allowed to use built-in reverse methods.

### Function Signature:
        ```java
public static String[] processStrings(String[] strings, String reference){
    String[] result= new String[strings.length];
    int n=strings.length;
    for(int i=0;i<n;i++){
        if(isAnagram(strings[i]), reference){
            result[i] = reverse(strings[i]);
        }
        else {
            result[i] = strings[i];
        }
    }
}
public static boolean isAnagram(String s1,String s2){
    if(s1.length()!=s2.length()) return false;

    int[] freq = new int[52];
    for(int i=0;i<s1.length();i++){
        freq[getIndex(s1.charAt(i))]++;
        freq[getIndex(s2.charAt(i))]--;

    }
    for(int count:freq){
        if(count!=0){
            return false;
        }
    }
    return true;

}

private static int getIndex(char ch){
    if(Character.isLowerCase(ch)){
        return ch-'a';
    }
    return 26+ (ch-'a');
}
public static String reverse(String str){
    char[] chars= str.toCharArray();
    int left=0,right=chars.length-1;
    while(left<right){
        char temp = chars[left];
        chars[left++]= chars[right];
        chars[right--]= temp;
    }
    return new String(chars);
}
```

        ### Example:
Input:
        ```java
String[] strings = {"listen", "silent", "enlist", "hello", "world"};
String reference = "listen";
```

Output:
        ```java
["netsil", "tnelis", "tsilne", "hello", "world"]
        ```

        ### Constraints:
        1. The input array `strings` will have at most 10,000 elements.
2. Each string in the array and the reference string will have a length between 1 and 100.
        3. The comparison should be case-sensitive (e.g., "Listen" is not an anagram of "listen").
        4. You may assume all inputs contain only lowercase or uppercase English letters.

        ### Additional Notes:
        - An anagram of a string is another string that contains the same characters in the same frequency but in a different order.
        - Implement a helper method to check if two strings are anagrams.
        - Write the code to reverse a string manually without using built-in reverse methods.

*/
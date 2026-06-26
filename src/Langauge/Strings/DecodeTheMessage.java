package Langauge.Strings;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(decode(key,message));
    }
    public static String decode(String key,String message){
        HashMap<Character,Character> code= new HashMap<>();
        int alpha=97;
        for(char ch:key.toCharArray()){
            if(ch==' ' || code.containsKey(ch)) continue;
            code.put(ch,(char) alpha++);
        }

        StringBuilder sb= new StringBuilder();
        for(char ch:message.toCharArray()){
            if(ch ==' ') {
                sb.append(' ');
            }
            else if(code.containsKey(ch)){
                sb.append(code.get(ch));
            }
        }
        return sb.toString();
    }
}

package sheet._1_ArraysAndHashing;

public class validAnagram {
    public static void main(String[] args) {
        String str1="rat", str2="car";
        int[] freq= new int[26];
        int i=0,j=0;
        while(i< str1.length() && j < str2.length()){
            freq[str1.charAt(i++)-'a']++;
            freq[str2.charAt(j++)-'a']--;
        }
        for(i=0;i< freq.length;i++){
            if(freq[i]!=0){
                System.out.println(" Not anagram");
                return ;
            }
        }
        System.out.println(" anagram ");
    }
}

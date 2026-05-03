package practice.basics;

public class AnagramCheck {
    public static boolean isAnagram(String a,String b){
        if(a==null || b==null && a.length()!=b.length()) return false;
        int[] arr= new int[26];
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-'a']++;
            arr[b.charAt(i)-'a']--;
        }
        for(int i:arr){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("listen","silent"));
        System.out.println(isAnagram("java","avaj"));
        System.out.println(isAnagram("test","text"));

    }
}

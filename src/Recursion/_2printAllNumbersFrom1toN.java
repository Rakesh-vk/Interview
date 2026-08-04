package Recursion;

public class _2printAllNumbersFrom1toN {
    public static void main(String[] args) {
        solution(1,5);
    }
    public static void Solution(int n){
        if(n==0) return;
        Solution(n-1);
        System.out.println(n+" ");
    }
    public static void solution(int a,int b){
        if(a==b+1){
            return ;
        }
        System.out.println(a);
        solution(a+1,b);
    }
}

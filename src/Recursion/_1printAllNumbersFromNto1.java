package Recursion;

public class _1printAllNumbersFromNto1 {
    public static void main(String[] args) {
        solution(4);
    }
    public static void solution(int n){
        if(n==0 ) return ;
        System.out.println(n);
        solution(n-1);
    }
}

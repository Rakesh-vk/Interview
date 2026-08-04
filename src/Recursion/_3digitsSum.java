package Recursion;

public class _3digitsSum {
    public static void main(String[] args) {
        System.out.println(solution(1234));
    }
    public static int solution(int n){
        if(n==0) return 0;
        return (n%10) + solution(n/10);
    }
}

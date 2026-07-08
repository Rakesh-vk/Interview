package Recursion;

public class factorial {
    public static void main(String[] args) {
        System.out.println(fact(4));
    }
    public static int fact(int n){
        if(n == 1) return 1;
        int result;
        result = fact(n-1)*n;
        return result;
    }
}
